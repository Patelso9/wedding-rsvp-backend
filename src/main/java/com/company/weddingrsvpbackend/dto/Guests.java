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
    @NotNull(message = "Please enter the guests phone number.")
    private long phoneNumber;
    @NotEmpty(message = "Please enter the street address.")
    private String street;
    @NotEmpty(message = "Please enter the city.")
    private String city;
    @NotEmpty(message = "Please enter the state.")
    private String state;
    @NotEmpty(message = "Please enter the zipcode.")
    private String zipcode;
    @NotNull(message = "Please enter the number of people that are attending.")
    private int numberAttending;

    public Guests() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getNumberAttending() {
        return numberAttending;
    }

    public void setNumberAttending(int numberAttending) {
        this.numberAttending = numberAttending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guests guests = (Guests) o;
        return phoneNumber == guests.phoneNumber && numberAttending == guests.numberAttending && Objects.equals(firstName, guests.firstName) && Objects.equals(lastName, guests.lastName) && Objects.equals(email, guests.email) && Objects.equals(street, guests.street) && Objects.equals(city, guests.city) && Objects.equals(state, guests.state) && Objects.equals(zipcode, guests.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber, street, city, state, zipcode, numberAttending);
    }

    @Override
    public String toString() {
        return "Guests{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", numberAttending=" + numberAttending +
                '}';
    }
}
