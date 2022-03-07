package com.company.weddingrsvpservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="guest")
public class RsvpGuests extends RsvpEvent{

    private int id;
    private int guest_event_id;
    private String name;
    private String email;
    private Boolean attending;

    public RsvpGuests() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getGuest_event_id() {
        return guest_event_id;
    }

    public void setGuest_event_id(int guest_event_id) {
        this.guest_event_id = guest_event_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!super.equals(o)) return false;
        RsvpGuests that = (RsvpGuests) o;
        return id == that.id && guest_event_id == that.guest_event_id && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(attending, that.attending);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, guest_event_id, name, email, attending);
    }

    @Override
    public String toString() {
        return "RsvpGuests{" +
                "id=" + id +
                ", guest_event_id=" + guest_event_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", attending=" + attending +
                '}';
    }
}
