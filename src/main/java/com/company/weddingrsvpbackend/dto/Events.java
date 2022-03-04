package com.company.weddingrsvpbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "events")
public class Events {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String venueName;
    private String venueAddress;
    private LocalDate eventDate;
    private LocalDateTime eventTime;
    private String eventDescription;
    private String attire;

    public Events() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getAttire() {
        return attire;
    }

    public void setAttire(String attire) {
        this.attire = attire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return Objects.equals(id, events.id) && Objects.equals(venueName, events.venueName) && Objects.equals(venueAddress, events.venueAddress) && Objects.equals(eventDate, events.eventDate) && Objects.equals(eventTime, events.eventTime) && Objects.equals(eventDescription, events.eventDescription) && Objects.equals(attire, events.attire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, venueName, venueAddress, eventDate, eventTime, eventDescription, attire);
    }

    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", venueName='" + venueName + '\'' +
                ", venueAddress='" + venueAddress + '\'' +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                ", eventDescription='" + eventDescription + '\'' +
                ", attire='" + attire + '\'' +
                '}';
    }
}
