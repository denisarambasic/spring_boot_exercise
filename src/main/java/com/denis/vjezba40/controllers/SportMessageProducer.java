package com.denis.vjezba40.controllers;

import com.denis.vjezba40.models.Sport;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportMessageProducer {
    public static final String TOPIC_EXCHANGE = "TOPIC_EXCHANGE";
    @Autowired private RabbitTemplate rabbitTemplate;
    public static final String DIRECT_EXCHANGE = "DIRECT_EXCHANGE";

    @PostMapping("/footballD")
    @ResponseStatus(HttpStatus.CREATED)
    public String sendMessageToFootballQueueD(@RequestBody Sport sport) {
        rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, "football", sport);
        return "Message send to football queue.";
    }

    @PostMapping("/basketballD")
    @ResponseStatus(HttpStatus.CREATED)
    public String sendMessageToBasketballQueueD(@RequestBody Sport sport) {
        rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, "basketball", sport);
        return "Message send to basketball queue.";
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public String sendMessageToAllQueues(@RequestBody Sport sport) {
        rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "", sport);
        return "Message send to all queues.";
    }

    @PostMapping("/footballT")
    @ResponseStatus(HttpStatus.CREATED)
    public String sendMessageToFootballQueueT(@RequestBody Sport sport) {
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, "sport.football.a.b", sport);
        return "Message send to football queue.";
    }

    @PostMapping("/basketballT")
    @ResponseStatus(HttpStatus.CREATED)
    public String sendMessageToBasketballQueueT(@RequestBody Sport sport) {
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, "sport.basketball.a.b", sport);
        return "Message send to basketball queue.";
    }
}
