package com.denis.vjezba40.controllers;

import com.denis.vjezba40.models.MessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageBroker {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageDTO handleMessages(MessageDTO message) {
        return message;
    }

}
