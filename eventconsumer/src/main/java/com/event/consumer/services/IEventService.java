package com.event.consumer.services;

import com.event.consumer.models.Event;
import com.event.consumer.models.Events;
import org.springframework.stereotype.Service;

@Service
public interface IEventService {
    Events getEvents();

    Event getEventById(String clientId);

    void saveOrUpdate(Event event);
}
