package cphbusiness.noInPuts.accountService.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Documentation and create Interface
@Service
public class RabbitMessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("test", "", message);
    }
}
