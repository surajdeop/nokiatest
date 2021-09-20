package com.event.consumer.services.impl;

import com.event.consumer.models.Event;
import com.event.consumer.services.IEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger( ConsumerService.class );
    @Autowired
    private Gson gson;
    @Autowired
    private IEventService eventService;

    @KafkaListener ( topics = "nokiaTopic", groupId = "nokia_id" )
    public void consumer( String message ) {
        Event event = gson.fromJson( message, Event.class );
        logger.info( String.format( "Consumed event: %s", event ) );
        eventService.saveOrUpdate( event );
    }
}
