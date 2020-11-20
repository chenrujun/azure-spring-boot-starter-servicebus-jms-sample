package chenrujun.azure.spring.boot.starter.servicebus.jms.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class TopicMessageReceiver {

    private static final String TOPIC_NAME = "<ServiceBusTopicName>";
    private static final String SUBSCRIPTION_NAME = "<ServiceBusSubscriptionName>";
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicMessageReceiver.class);

    @JmsListener(
        destination = TOPIC_NAME,
        containerFactory = "topicJmsListenerContainerFactory",
        subscription = SUBSCRIPTION_NAME
    )
    public void receiveMessage(User user) {
        LOGGER.info("Received message: {}", user.getName());
    }
}