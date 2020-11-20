package chenrujun.azure.spring.boot.starter.servicebus.jms.sample.topic;

import chenrujun.azure.spring.boot.starter.servicebus.jms.sample.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Subscription2Receiver1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Subscription2Receiver1.class);

    @JmsListener(
        containerFactory = "topicJmsListenerContainerFactory",
        destination = "rujche-topic",
        subscription = "rujche-subscription-2"
    )
    public void receiveMessage(User user) {
        LOGGER.info("Received message from rujche-subscription2, message = {}", user.getName());
    }
}