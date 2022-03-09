package com.company.weddingrsvpservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "event")
public class RsvpEvent implements Serializable {
    @Id
    @Column(name = "event_id" )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    @OneToMany(mappedBy = "guestId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RsvpGuests> guests;
    private String eventName;
    private String location;


    public RsvpEvent() {

    }

    public RsvpEvent(int id, Set<RsvpGuests> guests, String eventName, String location) {
        this.id = id;
        this.guests = guests;
        this.eventName = eventName;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<RsvpGuests> getGuests() {
        return guests;
    }

    public void setGuests(Set<RsvpGuests> guests) {
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
        RsvpEvent rsvpEvent = (RsvpEvent) o;
        return id == rsvpEvent.id && Objects.equals(guests, rsvpEvent.guests) && Objects.equals(eventName, rsvpEvent.eventName) && Objects.equals(location, rsvpEvent.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guests, eventName, location);
    }

    @Override
    public String toString() {
        return "RsvpEvent{" +
                "id=" + id +
                ", guests=" + guests +
                ", eventName='" + eventName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
