package com.subscription.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.subscription.main.Book;
import com.subscription.main.Subscription;
import com.subscription.main.SubscriptionDBQueries;
import com.subscription.main.SubscriptionRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class SubscriptionService {

private static final Logger logger=LoggerFactory.getLogger(SubscriptionService.class.getName());
	
	@Autowired
	private MessageProcess messageProcess;
	
	@Value("${BookService.path}")
	private String booksServicePath;

	@Autowired
	SubscriptionRepository subscriptionRepository;

	@Autowired
	SubscriptionDBQueries subscriptionDBQueries;

	@Autowired
	RestTemplate restTemplate;


	public List<Subscription> getAllSubscriptions() {
		return subscriptionRepository.findAll();
	}

	@HystrixCommand(fallbackMethod = "fallBack_subscribeBook", commandProperties = {  
			  @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			  @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold", value="3"),
			  @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds", value="10000"),
			  @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage", value="50"),
			  @HystrixProperty(name ="metrics.rollingStats.timeInMilliseconds", value="10000")
			  }) 
	public String subscribeBook(Subscription subscription) {
		
		String result="";
		String URL="http://BookService/books/"+subscription.getBookId();
		Book book =restTemplate.getForObject(URL, Book.class);
		
		logger.info("Book Service called for getting book information "+book.toString());
		
		if(book.getAvailable_copies()>0 && book.getAvailable_copies()<=book.getTotal_copies()) {
					
			if(subscriptionDBQueries.checkSubscriptionAlreadyExistInDBWithoutReturn(subscription)) {
					URL="http://BookService/books/UpdateAvailability/"+subscription.getBookId()+"/"+"-1";
					restTemplate.postForObject(URL,subscription,Book.class);
					logger.info("Book Service called for decrementing copies available for bookId:"+book.getId());
					subscriptionRepository.save(subscription);
					result="Book Subscribed Successfully";
					
				}
				else {
					result="Book Already Subscribed";
				}
		}
		else{
			
			if(subscription.getNotify().equalsIgnoreCase("YES")) {
				messageProcess.sendMessage(book.getId(),subscription.getSubscriberName());
			}
			result="NO Copies available for this book, Please try again later";
		}
		logger.info("result:"+result);
		return result;
	}

	public String fallBack_subscribeBook(Subscription subscription) {
		logger.info("Book Service is down right now!!! So Cannot subscribe the book!!");
		return "Book Service is down right now!!! So Cannot subscribe the book!!";
	}

	@HystrixCommand(fallbackMethod = "fallBack_returnBook", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000") })
	public String returnBook(Subscription subscription) {

		Subscription subscriptionFromDB = subscriptionDBQueries.findByBookIdAndSubscriberName(subscription).get(0);
		String result = "";
		String URL = "http://BookService/books/" + subscription.getBookId();
		Book book = restTemplate.getForObject(URL, Book.class);

		logger.info("Book Service called for getting book information "+book.toString());
		
		if (book.getAvailable_copies() < book.getTotal_copies()) {

			URL = "http://BookService/books/UpdateAvailability/" + subscription.getBookId() + "/" + "1";
			restTemplate.postForObject(URL, subscription, Book.class);
			logger.info("Book Service called for incrementing copies available for bookId:"+book.getId());
			subscriptionFromDB.setDateReturned(subscription.getDateReturned());
			subscriptionRepository.save(subscriptionFromDB);
			result = "Book Returned Successfully";
	
		} else {

			result = "Book Already Returned";
		}
		logger.info("result:"+result);
		return result;
	}

	public String fallBack_returnBook(Subscription subscription) {
		logger.info("Book Service is down right now!!! So Cannot return the book!!");
		return "Book Service is down right now!!! So Cannot return the book!!";
	}

}
