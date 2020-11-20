package chenrujun.azure.spring.boot.starter.servicebus.jms.sample.topic.subscription.two;

import chenrujun.azure.spring.boot.starter.servicebus.jms.sample.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class Subscription2Receiver2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Subscription2Receiver2.class);

    @JmsListener(
        containerFactory = "topicJmsListenerContainerFactory",
        destination = "rujche-topic",
        subscription = "rujche-subscription-2"
    )
    public void receiveMessage(User user) {
        LOGGER.info("Received message from rujche-subscription2, message = {}", user.getName());
    }
}