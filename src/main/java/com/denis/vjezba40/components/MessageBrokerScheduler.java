package com.denis.vjezba40.components;

import com.denis.vjezba40.models.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//@EnableScheduling
public class MessageBrokerScheduler {
    @Autowired private SimpMessagingTemplate simpMessagingTemplate;
    private static int COUNTER = 0;

    //@Scheduled(fixedDelay = 5_000L)
    public void sendMessageToTopicMessagesSubscribers() {
        MessageDTO message = new MessageDTO("message_" + COUNTER);
        simpMessagingTemplate.convertAndSend("/topic/messages", message);
        COUNTER++;
    }
}
