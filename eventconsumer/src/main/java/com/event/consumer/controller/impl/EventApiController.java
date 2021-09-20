package com.event.consumer.controller.impl;

import com.event.consumer.controller.EventApi;
import com.event.consumer.models.Event;
import com.event.consumer.models.Events;
import com.event.consumer.services.IEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventApiController implements EventApi {
    private static final Logger logger = LoggerFactory.getLogger( EventApiController.class );

    @Autowired
    private IEventService eventService;

    @Override
    public ResponseEntity<Events> getEvents() {
        MDC.put( PROCESS_ID, LIST_EVENTS );
        logger.info( "Getting all Events" );
        Events events = eventService.getEvents();
        MDC.remove( PROCESS_ID );
        return new ResponseEntity<>( events, HttpStatus.OK );
    }

    @Override
    public ResponseEntity<Event> getEventByEmpId(String empId ) {
        MDC.put( PROCESS_ID, EVENT_BY_EMP_ID );
        logger.info( "Get Entity by employee id" );
        try {
            Event event = eventService.getEventById( empId );
            return new ResponseEntity<>( event, HttpStatus.OK );
        } catch ( Exception e ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        } finally {
            MDC.remove( PROCESS_ID );
        }
    }

}