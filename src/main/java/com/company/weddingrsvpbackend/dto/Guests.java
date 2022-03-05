package com.company.weddingrsvpbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.net.Inet4Address;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "guests")
public class Guests {

    @Id
    @Column(name = "guest_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "Please enter the guests first name.")
    private String firstName;
    @NotEmpty(message = "Please enter the guests last name.")
    private String lastName;
    @NotEmpty(message = "Please enter the guests email.")
    private String email;


    public Guests() {
    }



}
