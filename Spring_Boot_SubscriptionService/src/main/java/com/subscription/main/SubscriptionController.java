package com.subscription.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.subscription.main.Book;
import com.subscription.main.Subscription;
import com.subscription.main.SubscriptionService;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {

	private static final String template = "Subscribe User Name, %s!";

	public SubscriptionController()
	{}
	
	

	@Autowired
	SubscriptionService subscriptionService;
	
	@GetMapping(value="/subscription",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Subscription> getAllSubscriptions(){
		return subscriptionService.getAllSubscriptions();
	}
		
	@PostMapping(value="/subscription/subscribe",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String subscribeBook(@RequestBody Subscription subscription) {
		return subscriptionService.subscribeBook(subscription);
	}
	
	@PostMapping(value="/subscription/returns",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String returnBook(@RequestBody Subscription subscription) {
		return subscriptionService.returnBook(subscription);
	}
	

	
}
