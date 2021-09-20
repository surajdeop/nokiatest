package com.event.consumer.services.impl;

import com.event.consumer.models.Events;
import com.event.consumer.models.Event;
import com.event.consumer.repository.EventRepository;
import com.event.consumer.services.IEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService {
    private static final Logger logger = LoggerFactory.getLogger(EventService.class);
    @Autowired
    private EventRepository eventRepository;

    // getting all Entity records
    @Override
    public Events getEvents() {
        logger.info("Get all events");
        Events events = new Events();
        eventRepository.findAll().forEach(event -> events.getEvents().add(event));
        return events;
    }

    // getting a specific record
    @Override
    public Event getEventById(String clientId) {
        return eventRepository.findById(clientId).get();
    }

    @Override
    public void saveOrUpdate(Event event) {
        eventRepository.save(event);
    }

}