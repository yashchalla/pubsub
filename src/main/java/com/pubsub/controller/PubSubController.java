package com.pubsub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pubsub.Message;
import com.pubsub.service.PubSubService;
import com.pubsub.subscriber.Subscriber;

@RestController
@RequestMapping("/api")
public class PubSubController {
	
	@Autowired
	private PubSubService pubSubService;
	
	@GetMapping("/test")
	public ResponseEntity<String> test(){
		Message message = new Message("Java","New java subscrober");
		pubSubService.addMessageToQueue(message);
		return ResponseEntity.ok("Message published succesfully");
	}
	
	@PutMapping("/publish")
	public ResponseEntity<String> publishMessage(@RequestBody Message message){
		pubSubService.addMessageToQueue(message);
		return ResponseEntity.ok("Message published succesfully");
	}
	
	@PutMapping("/addSubscriber")
	public ResponseEntity<String> addSubscriber(@RequestBody Subscriber subscriber){
		pubSubService.addSubscriber("Java",subscriber);
		return ResponseEntity.ok("Message published succesfully");
	}
}
