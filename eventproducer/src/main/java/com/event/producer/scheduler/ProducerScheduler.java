package com.event.producer.scheduler;

import com.event.producer.services.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProducerScheduler {
    @Autowired
    private IProducerService producerService;


    @Scheduled(fixedRate = 30000)
    public void producer() {
        producerService.sendEvent();
    }
}
