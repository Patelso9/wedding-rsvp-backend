package com.company.weddingrsvpservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="guest")
public class RsvpGuests {
    @Id
    @Column(name = "guest_id" )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int guest_event_id;
    private String guestName;
    private String guestEmail;
    private String totalInvited;
    private Boolean attending;

    public RsvpGuests() {
    }

    public RsvpGuests(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuest_event_id() {
        return guest_event_id;
    }

    public void setGuest_event_id(int guest_event_id) {
        this.guest_event_id = guest_event_id;
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

    public String getTotalInvited() {
        return totalInvited;
    }

    public void setTotalInvited(String totalInvited) {
        this.totalInvited = totalInvited;
    }

    public Boolean getAttending() {
        return attending;
    }

    public void setAttending(Boolean attending) {
        this.attending = attending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RsvpGuests that = (RsvpGuests) o;
        return id == that.id && guest_event_id == that.guest_event_id && Objects.equals(guestName, that.guestName) && Objects.equals(guestEmail, that.guestEmail) && Objects.equals(totalInvited, that.totalInvited) && Objects.equals(attending, that.attending);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guest_event_id, guestName, guestEmail, totalInvited, attending);
    }

    @Override
    public String toString() {
        return "RsvpGuests{" +
                "id=" + id +
                ", guest_event_id=" + guest_event_id +
                ", guestName='" + guestName + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                ", totalInvited='" + totalInvited + '\'' +
                ", attending=" + attending +
                '}';
    }
}
