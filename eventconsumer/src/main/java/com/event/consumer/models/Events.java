package com.event.consumer.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class Events {
    @JsonProperty("events")
    private List<Event> events = new ArrayList<>();

    public Events addEvent(Event event) {
        this.events.add(event);
        return this;
    }

    @ApiModelProperty
    public List<Event> getEvents() {
        return events;
    }
}
