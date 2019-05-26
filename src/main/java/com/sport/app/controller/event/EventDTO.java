package com.sport.app.controller.event;

import com.sport.app.repository.entity.Event;

public class EventDTO {

    public EventDTO() {};

    public EventDTO(Event event) {
        setId(event.getId());
        setApplicationUserId(event.getApplicationUser().getId());
        setPlace(event.getPlace());
        setText(event.getText());
        setTime(event.getTime().toString());
    }

    private int id;
    private int applicationUserId;
    private String time;
    private String place;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicationUserId() {
        return applicationUserId;
    }

    public void setApplicationUserId(int applicationUserId) {
        this.applicationUserId = applicationUserId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
