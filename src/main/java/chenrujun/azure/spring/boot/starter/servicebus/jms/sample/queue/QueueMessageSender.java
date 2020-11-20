package chenrujun.azure.spring.boot.starter.servicebus.jms.sample.queue;

import chenrujun.azure.spring.boot.starter.servicebus.jms.sample.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueMessageSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueMessageSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/messages")
    public String postMessage(@RequestParam String message) {
        LOGGER.info("Sending queue message: {}", message);
        jmsTemplate.convertAndSend("rujche-queue", new User(message));
        return "Queue message sent. message = " + message;
    }
}
