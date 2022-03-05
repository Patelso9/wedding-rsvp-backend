package com.company.weddingrsvpbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="wedding_rsvp")
public class Rsvp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String guestName;
    private int totalAttending;
}
