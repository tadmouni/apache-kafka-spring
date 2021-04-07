package com.okta.javakafka.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestTopicConsumer {
	private final List<String> messages = new ArrayList<>();
	
	@KafkaListener(topics = "testTopic", groupId = "kafka-sandbox")
	public void listen(String message) {
		synchronized (messages) {
			messages.add(message);
		}
	}
	
	public List<String> getMessages() {
		return messages;
	}
}
