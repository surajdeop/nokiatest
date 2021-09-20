package com.event.producer.models;
import java.util.Date;

public class Event {

    private String empId;
    private String name;
    private String dept;
    private Date time;

    public Event( String name, String dept, String empId, Date time ) {
        super();
        this.name = name;
        this.dept = dept;
        this.empId = empId;
        this.time = time;
    }

    // Name:XXXXX,Dept=OSS,EmplD:1234, Time=21-7-2021 21:00:10
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "Name:" );
        builder.append( name );
        builder.append( ", Dept=" );
        builder.append( dept );
        builder.append( ", EmplD=" );
        builder.append( empId );
        builder.append( ", Time=" );
        builder.append( time );
        return builder.toString();
    }
}
