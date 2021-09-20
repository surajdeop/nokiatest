package com.event.producer.services.impl;

import com.event.producer.models.Event;
import com.event.producer.services.IProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


@Service
public final class ProducerService implements IProducerService {
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private Gson gson;

    @Override
    public void sendEvent() {
        Event event = getEvent();
        logger.info(String.format("Producing events: %s", event));

        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(TOPIC, gson.toJson(event));
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Unable to send event=[ {} ] due to : {}", event, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("Sent event=[ {} ] with offset=[ {} ]", event, result.getRecordMetadata().offset());
            }
        });
    }

    private Event getEvent() {
        int leftLimit = 65; // letter 'A'
        int rightLimit = 90; // letter 'Z'
        String name = gerateString( leftLimit, rightLimit, 5 );
        String dept = gerateString( leftLimit, rightLimit, 4 );
        String empId = gerateString( 48, 57, 5 );

        return new Event( name, dept, empId, new Date() );
    }

    private String gerateString( int leftLimit, int rightLimit, int targetStringLength ) {

        Random random = new Random();

        return random.ints( leftLimit, rightLimit + 1 ).limit( targetStringLength ).collect( StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append ).toString();
    }
}
