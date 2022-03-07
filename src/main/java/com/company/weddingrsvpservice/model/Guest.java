package com.company.weddingrsvpservice.model;

import com.company.weddingrsvpservice.util.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "guest")
public class Guest extends EventEntity {

    @Column(name = "unique_id")
    private String uniqueId;

    @Column(name = "guest_name")
    private String guestName;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private StatusEnum guestStatus;

    @Column(name = "message_from_guest")
    @Type(type = "text")
    private String messageFromGuest;

    @ManyToOne
    @JoinColumn(name = "guest_event_id", referencedColumnName = "id")
    private EventEntity eventGuest;

    public String getGuestId() {
        return uniqueId;
    }

    public void setGuestId(String guestId) {
        this.uniqueId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StatusEnum getGuestStatus() {
        return guestStatus;
    }

    public void setGuestStatus(StatusEnum guestStatus) {
        this.guestStatus = guestStatus;
    }

    public String getMessageFromGuest() {
        return messageFromGuest;
    }

    public void setMessageFromGuest(String messageFromGuest) {
        this.messageFromGuest = messageFromGuest;
    }

    public EventEntity getEventGuest() {
        return eventGuest;
    }

    public void setEventGuest(EventEntity eventGuest) {
        this.eventGuest = eventGuest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(uniqueId, guest.uniqueId) && Objects.equals(guestName, guest.guestName) && Objects.equals(email, guest.email) && guestStatus == guest.guestStatus && Objects.equals(messageFromGuest, guest.messageFromGuest) && Objects.equals(eventGuest, guest.eventGuest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueId, guestName, email, guestStatus, messageFromGuest, eventGuest);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId='" + uniqueId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", email='" + email + '\'' +
                ", guestStatus=" + guestStatus +
                ", messageFromGuest='" + messageFromGuest + '\'' +
                ", eventGuest=" + eventGuest +
                '}';
    }
}
