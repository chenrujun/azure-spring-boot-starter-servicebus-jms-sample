package chenrujun.azure.spring.boot.starter.servicebus.jms.sample;

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

    private static final String DESTINATION_NAME = "rujche-queue";

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueMessageSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/messages")
    public String postMessage(@RequestParam String message) {
        LOGGER.info("Sending message: {}", message);
        jmsTemplate.convertAndSend(DESTINATION_NAME, new User(message));
        return "Message sent. message = " + message;
    }
}
