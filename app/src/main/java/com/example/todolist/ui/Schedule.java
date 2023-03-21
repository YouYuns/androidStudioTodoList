package com.example.todolist.ui;


public class Schedule {
    private Long id;
    private String startTime;
    private String endTime;
    private String schedule;


    public Schedule() {
    }

    public Schedule(Long id, String startTime, String endTime, String schedule) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.schedule = schedule;
    }

    public Schedule(String schedule, String startTime, String endTime) {
        this.schedule=schedule;
        this.startTime =startTime;
        this.endTime=endTime;

    }

    public Long getId(String key) {
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
