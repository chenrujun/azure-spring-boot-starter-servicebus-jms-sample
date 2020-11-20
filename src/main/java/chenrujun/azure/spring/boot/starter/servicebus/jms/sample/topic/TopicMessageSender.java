// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package chenrujun.azure.spring.boot.starter.servicebus.jms.sample.topic;

import chenrujun.azure.spring.boot.starter.servicebus.jms.sample.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicMessageSender {

    private static final Logger logger = LoggerFactory.getLogger(TopicMessageSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/topic")
    public String postMessage(@RequestParam String message) {
        logger.info("Sent topic message. message = {}", message);
        jmsTemplate.convertAndSend("rujche-topic", new User(message));
        return "Sent topic message. message = " + message;
    }
}
