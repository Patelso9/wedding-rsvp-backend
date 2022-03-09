package com.company.weddingrsvpservice.model;

import com.company.weddingrsvpservice.viewmodel.EventsViewModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="guest")
public class RsvpGuests {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "guest_id" )
    private Integer guestId;

    private String guestName;
    private String guestEmail;
    private Integer totalInvited;
    private Boolean attending;

    public RsvpGuests() {
    }

    public RsvpGuests(int id, Integer guestId, String guestName, String guestEmail, Integer totalInvited, Boolean attending) {
        this.id = id;
        this.guestId = guestId;
        this.guestName = guestName;
        this.guestEmail = guestEmail;
        this.totalInvited = totalInvited;
        this.attending = attending;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
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

    public Integer getTotalInvited() {
        return totalInvited;
    }

    public void setTotalInvited(Integer totalInvited) {
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
        RsvpGuests guests = (RsvpGuests) o;
        return id == guests.id && Objects.equals(guestId, guests.guestId) && Objects.equals(guestName, guests.guestName) && Objects.equals(guestEmail, guests.guestEmail) && Objects.equals(totalInvited, guests.totalInvited) && Objects.equals(attending, guests.attending);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guestId, guestName, guestEmail, totalInvited, attending);
    }

    @Override
    public String toString() {
        return "RsvpGuests{" +
                "id=" + id +
                ", guestId=" + guestId +
                ", guestName='" + guestName + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                ", totalInvited=" + totalInvited +
                ", attending=" + attending +
                '}';
    }
}
