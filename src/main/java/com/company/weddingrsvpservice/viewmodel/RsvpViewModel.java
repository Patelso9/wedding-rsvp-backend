package com.company.weddingrsvpservice.viewmodel;

import com.company.weddingrsvpservice.model.RsvpGuests;

import java.util.ArrayList;
import java.util.List;

public class RsvpViewModel {
    private  int id;



    private  RsvpGuests guestId;
    private int eventId;
    private String guestName;
    private String guestEmail;
    private int totalAttending;
    private String description;
    private List<RsvpGuests> eventList = new ArrayList<>();

   public void setRsvpGuests(List<RsvpGuests> eventList){
       this.guestId = guestId;
   }

    public RsvpGuests guestId() {
       return guestId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RsvpGuests getGuestId() {
        return guestId;
    }

    public RsvpGuests getRsvpGuests() {
        return guestId;
    }

    public void RsvpGuests () {
        this.guestId = guestId;
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
}
