package com.event.consumer.repository;

import com.event.consumer.models.Event;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CassandraRepository<Event, String> {
}
