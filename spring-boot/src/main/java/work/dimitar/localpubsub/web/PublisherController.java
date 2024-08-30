package work.dimitar.localpubsub.web;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PublisherController {
    private final PubSubTemplate pubSubTemplate;


    @PostMapping("/publish")
    public String publishMessage(@RequestParam("message") String message) {
        pubSubTemplate.publish("test-v1-topic", message);
        return "Message published successfully.";
    }

}
