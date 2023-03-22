package com.example.todolist.ui;

import java.time.LocalDate;
import java.util.Date;


public class Schedule {
    private Long id;
    private String startTime;
    private String endTime;
    private String schedule;

    private Date saveTime;


    public Schedule() {
    }

    public Schedule(String schedule, String startTime, String endTime, Date now) {
        this.schedule=schedule;
        this.startTime =startTime;
        this.endTime=endTime;
        this.saveTime=now;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
