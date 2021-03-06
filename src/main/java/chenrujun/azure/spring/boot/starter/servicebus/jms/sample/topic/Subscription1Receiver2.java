package chenrujun.azure.spring.boot.starter.servicebus.jms.sample.topic;

import chenrujun.azure.spring.boot.starter.servicebus.jms.sample.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

//@Component
public class Subscription1Receiver2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Subscription1Receiver2.class);

    @JmsListener(
        containerFactory = "topicJmsListenerContainerFactory",
        destination = "rujche-topic",
        subscription = "rujche-subscription-1"
    )
    public void receiveMessage(User user) {
        LOGGER.info("Received message from rujche-subscription1, message = {}", user.getName());
    }
}