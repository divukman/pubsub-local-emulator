package work.dimitar.localpubsub.service;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.stereotype.Service;

@Service
public class PubSubSubscriberService {

    private final PubSubTemplate pubSubTemplate;

    public PubSubSubscriberService(PubSubTemplate pubSubTemplate) {
        this.pubSubTemplate = pubSubTemplate;
        subscribeToTopic("test-v1-subscription");
    }

    public void subscribeToTopic(String subscriptionName) {
        pubSubTemplate.subscribe(subscriptionName, this::messageReceiver);
    }

    private void messageReceiver(BasicAcknowledgeablePubsubMessage message) {
        System.out.println("Message received: " + message.getPubsubMessage().getData().toStringUtf8());
        // Acknowledge the message
        message.ack();
    }
}
