package com.denis.vjezba40.components;

import com.denis.vjezba40.models.Sport;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//@EnableScheduling
public class SportMessageScheduler {
    @Autowired private RabbitTemplate rabbitTemplate;
    private static int COUNTER;

    //@Scheduled(fixedDelay = 5_000L)
    public void sendCustomSportMessagesToAllQueuesEvery5Sec() {
        Sport sport = new Sport("Sport", "event_" + COUNTER + " - " + "event_" + COUNTER);
        rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "", sport);
        COUNTER++;
    }
}
