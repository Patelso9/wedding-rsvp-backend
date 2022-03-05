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
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private int guestId;
    private String guestName;
    private String guestEmail;
    private int totalAttending;
    private String description;

    public RsvpEvent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RsvpEvent rsvpEvent = (RsvpEvent) o;
        return id == rsvpEvent.id && guestId == rsvpEvent.guestId && totalAttending == rsvpEvent.totalAttending && Objects.equals(guestName, rsvpEvent.guestName) && Objects.equals(guestEmail, rsvpEvent.guestEmail) && Objects.equals(description, rsvpEvent.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guestId, guestName, guestEmail, totalAttending, description);
    }

    @Override
    public String toString() {
        return "RsvpEvent{" +
                "id=" + id +
                ", guestId=" + guestId +
                ", guestName='" + guestName + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                ", totalAttending=" + totalAttending +
                ", description='" + description + '\'' +
                '}';
    }
}
