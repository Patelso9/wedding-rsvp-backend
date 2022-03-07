package com.company.weddingrsvpservice.viewmodel;

import com.company.weddingrsvpservice.model.RsvpGuests;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RsvpViewModel {

    private int id;
    private RsvpGuests guests;
    private String eventName;
    private String location;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RsvpViewModel that = (RsvpViewModel) o;
        return id == that.id && Objects.equals(guests, that.guests) && Objects.equals(eventName, that.eventName) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guests, eventName, location);
    }

    @Override
    public String toString() {
        return "RsvpViewModel{" +
                "id=" + id +
                ", guests=" + guests +
                ", eventName='" + eventName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}