package com.subscription.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProcess {

	private static final Logger subscriptionLoger = LoggerFactory.getLogger(MessageProcess.class);
		
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String topic,String message) {
		subscriptionLoger.info(String.format("$$ -> Producing message --> %s", message));
		this.kafkaTemplate.send(topic,message);
	}

	
}
