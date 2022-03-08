package com.company.weddingrsvpservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "event")
public class RsvpEvent implements Serializable {
    @Id
    @Column(name = "event_id" )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    private String eventName;
    private String location;

    public RsvpEvent(int id, String eventName, String location) {
        this.id = id;
        this.eventName = eventName;
        this.location = location;
    }

    public RsvpEvent() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id == rsvpEvent.id && Objects.equals(eventName, rsvpEvent.eventName) && Objects.equals(location, rsvpEvent.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventName, location);
    }

    @Override
    public String toString() {
        return "RsvpEvent{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
