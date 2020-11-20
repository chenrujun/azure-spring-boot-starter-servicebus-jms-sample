package chenrujun.azure.spring.boot.starter.servicebus.jms.sample.queue;

import chenrujun.azure.spring.boot.starter.servicebus.jms.sample.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueMessageReceiver1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueMessageReceiver1.class);

    @JmsListener(destination = "rujche-queue", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(User user) {
        LOGGER.info("Received queue message: {}", user.getName());
    }
}
