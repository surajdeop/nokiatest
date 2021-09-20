package com.event.consumer.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Event {
    @PrimaryKey
    private String empId;
    private String name;
    private String dept;
    @JsonFormat(pattern = "dd-M-yyyy HH:mm:ss")
    private Date time;

    /**
     * @return the empId
     */
    @ApiModelProperty(required = true, value = "")
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the name
     */
    @ApiModelProperty(required = true, value = "")
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dept
     */
    @ApiModelProperty(required = true, value = "")
    public String getDept() {
        return dept;
    }

    /**
     * @param dept the dept to set
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * @return the time
     */
    @ApiModelProperty(required = true, value = "")
    @JsonFormat(pattern = "dd-M-yyyy HH:mm:ss")
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }

    // Name:XXXXX,Dept=OSS,EmplD:1234, Time=21-7-2021 21:00:10
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name:");
        builder.append(name);
        builder.append(", Dept=");
        builder.append(dept);
        builder.append(", EmplD=");
        builder.append(empId);
        builder.append(", Time=");
        builder.append(time);
        return builder.toString();
    }
}