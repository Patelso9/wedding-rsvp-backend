package com.company.weddingrsvpservice.viewmodel;

import com.company.weddingrsvpservice.model.RsvpGuests;

import java.util.Objects;

public class EventsViewModel {

    private int id;
    private RsvpGuests guests;
    private String eventName;
    private Integer totalAttending;
    private String location;


    public EventsViewModel() {
    }

    public EventsViewModel(int id, RsvpGuests guests, String eventName, Integer totalAttending, String location) {
        this.id = id;
        this.guests = guests;
        this.eventName = eventName;
        this.totalAttending = totalAttending;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RsvpGuests getGuests() {
        return guests;
    }

    public void setGuests(RsvpGuests guests) {
        this.guests = guests;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getTotalAttending() {
        return totalAttending;
    }

    public void setTotalAttending(Integer totalAttending) {
        this.totalAttending = totalAttending;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "EventsViewModel{" +
                "id=" + id +
                ", guests=" + guests +
                ", eventName='" + eventName + '\'' +
                ", totalAttending=" + totalAttending +
                ", location='" + location + '\'' +
                '}';
    }
}
