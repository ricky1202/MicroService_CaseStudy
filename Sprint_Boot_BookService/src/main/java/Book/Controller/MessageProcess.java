package Book.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProcess {

	private static final Logger bookLoger = LoggerFactory.getLogger(MessageProcess.class);
	
	private static final String book_TOPIC = "Book_Stock_Topic";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		bookLoger.info(String.format("$$ -> Process Book Service Request --> %s", message));
		this.kafkaTemplate.send(book_TOPIC,message);
	}
	
}
