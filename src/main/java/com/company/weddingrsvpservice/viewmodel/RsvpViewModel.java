package com.company.weddingrsvpservice.viewmodel;

import com.company.weddingrsvpservice.model.RsvpGuests;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RsvpViewModel {
    private int id;
    //private  RsvpGuests guest_Id;
    private int eventId;
    private String guestName;
    private String guestEmail;
    private int totalAttending;
    private String description;
    private List<RsvpGuests> eventList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public int getTotalAttending() {
        return totalAttending;
    }

    public void setTotalAttending(int totalAttending) {
        this.totalAttending = totalAttending;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RsvpGuests> getEventList() {
        return eventList;
    }

    public void setEventList(List<RsvpGuests> eventList) {
        this.eventList = eventList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RsvpViewModel that = (RsvpViewModel) o;
        return id == that.id && eventId == that.eventId && totalAttending == that.totalAttending && Objects.equals(guestName, that.guestName) && Objects.equals(guestEmail, that.guestEmail) && Objects.equals(description, that.description) && Objects.equals(eventList, that.eventList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventId, guestName, guestEmail, totalAttending, description, eventList);
    }

    @Override
    public String toString() {
        return "RsvpViewModel{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", guestName='" + guestName + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                ", totalAttending=" + totalAttending +
                ", description='" + description + '\'' +
                ", eventList=" + eventList +
                '}';
    }
}