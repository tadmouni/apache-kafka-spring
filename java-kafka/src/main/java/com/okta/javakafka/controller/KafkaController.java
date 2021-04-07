package com.okta.javakafka.controller;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.okta.javakafka.consumer.TestTopicConsumer;

@RestController
public class KafkaController {
	
	private KafkaTemplate<String, String> template;
	private TestTopicConsumer testTopicConsumer;
	
	public KafkaController(KafkaTemplate<String, String> template, TestTopicConsumer testTopicConsumer) {
		this.template = template;
		this.testTopicConsumer = testTopicConsumer;
	}
	
	@GetMapping("/kafka/produce")
	public void produce(@RequestParam String message) {
		template.send("testTopic", message);
	}
	
	@GetMapping("/kafka/messages")
	public List<String> getMessages() {
		return testTopicConsumer.getMessages();
	}

}

