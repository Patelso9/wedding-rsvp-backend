package com.company.weddingrsvpservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="guest")
public class RsvpGuests {
    @Id
    @Column(name = "guest_id" )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private List<RsvpEvent> event_id;
    @NotNull(message = "Please enter your full name.")
    private String guestName;
    @NotNull(message = "Please enter your email.")
    private String guestEmail;
    @NotNull(message = "Please enter total number of people attending the event.")
    private String totalInvited;
    @NotNull(message = "Please inform the admin if you are attending the event.")
    private Boolean attending;

    public RsvpGuests() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<RsvpEvent> getEvent_id() {
        return event_id;
    }

    public void setEvent_id(List<RsvpEvent> event_id) {
        this.event_id = event_id;
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
        return id == that.id && Objects.equals(event_id, that.event_id) && Objects.equals(guestName, that.guestName) && Objects.equals(guestEmail, that.guestEmail) && Objects.equals(totalInvited, that.totalInvited) && Objects.equals(attending, that.attending);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, event_id, guestName, guestEmail, totalInvited, attending);
    }

    @Override
    public String toString() {
        return "RsvpGuests{" +
                "id=" + id +
                ", event_id=" + event_id +
                ", guestName='" + guestName + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                ", totalInvited='" + totalInvited + '\'' +
                ", attending=" + attending +
                '}';
    }
}
