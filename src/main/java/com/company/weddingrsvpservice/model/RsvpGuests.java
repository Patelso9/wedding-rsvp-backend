package com.company.weddingrsvpservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyIntializer", "handler"})
@Table(name="guest")
public class RsvpGuests implements Serializable {

    @Id
    @Column(name = "guest_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int event_id;
    private String name;
    private String email;
    private Boolean attending;

    public RsvpGuests() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
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
        RsvpGuests that = (RsvpGuests) o;
        return id == that.id && event_id == that.event_id && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(attending, that.attending);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, event_id, name, email, attending);
    }

    @Override
    public String toString() {
        return "RsvpGuests{" +
                "id=" + id +
                ", event_id=" + event_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", attending=" + attending +
                '}';
    }
}
