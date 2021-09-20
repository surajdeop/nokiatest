package com.event.consumer.controller;


import com.event.consumer.models.Event;
import com.event.consumer.models.Events;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Surajdeo Prasad
 */
@RestController
@RequestMapping(value = "/nokia")
@Api(tags = "event-api")
public interface EventApi {
    String PROCESS_ID = "PROCESS_ID";
    String LIST_EVENTS = "LIST_EVENTS";
    String EVENT_BY_EMP_ID = "EVENT_BY_EMP_ID";

    /**
     * End point to get all Event
     *
     * @return ResponseEvent Content of License configuration file
     */
    @ApiOperation(value = "get all Event", response = Events.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully read all Event"), @ApiResponse(code = 500, message = "Failed to get Event")})
    @GetMapping(value = "/", produces = "application/json")
    ResponseEntity<Events> getEvents();

    @ApiOperation(value = "Find Event by employee id", nickname = "getEventByEmpId", notes = "Returns a single Event", response = Event.class, tags = {"event-api",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = Event.class),
            @ApiResponse(code = 400, message = "Invalid ID Employee Id"),
            @ApiResponse(code = 404, message = "Event not found")})
    @GetMapping(value = "/{empId}", produces = "application/json")
    ResponseEntity<Event> getEventByEmpId(@ApiParam(value = "Client id of Event to return", required = true) @PathVariable("empId") String empId);

}
