package com.example.todolist.ui;

import java.time.LocalDate;



public class Schedule {
    private Long id;
    private LocalDate startTime;
    private LocalDate endTime;
    private String schedule;

    public Schedule(Long id, LocalDate startTime, LocalDate endTime, String schedule) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
