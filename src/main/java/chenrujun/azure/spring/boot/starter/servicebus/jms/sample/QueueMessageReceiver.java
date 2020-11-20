package chenrujun.azure.spring.boot.starter.servicebus.jms.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueMessageReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueMessageReceiver.class);
    private static final String QUEUE_NAME = "rujche-queue";

    @JmsListener(destination = QUEUE_NAME, containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(User user) {
        LOGGER.info("Received message: {}", user.getName());
    }
}
