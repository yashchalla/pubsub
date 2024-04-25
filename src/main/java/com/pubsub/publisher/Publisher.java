package com.pubsub.publisher;
import com.pubsub.Message;
import com.pubsub.service.PubSubService;
public interface Publisher {
	// Publishes new message to PubSubService
	void publish(Message message, PubSubService pubsubService);

}
