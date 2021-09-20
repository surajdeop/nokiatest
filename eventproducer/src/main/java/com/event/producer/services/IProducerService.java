package com.event.producer.services;

import com.event.producer.models.Event;

public interface IProducerService {
    String TOPIC="nokiaTopic";
    void sendEvent();
}
