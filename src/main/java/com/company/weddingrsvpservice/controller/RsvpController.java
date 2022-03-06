package com.company.weddingrsvpservice.controller;

import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import com.company.weddingrsvpservice.repository.EventRepository;
import com.company.weddingrsvpservice.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RsvpController {

   @Autowired
    EventRepository eventRepository;
    GuestRepository guestRepository;

    public RsvpController(EventRepository eventRepository,GuestRepository guestRepository){
        this.eventRepository = eventRepository;
        this.guestRepository =guestRepository;
    }

    @PostMapping("/rsvpGuest")
    @ResponseStatus(HttpStatus.CREATED)
    public RsvpGuests createEvent(@RequestBody RsvpGuests guests){

        guests.setEvent_id(1);
        System.out.println("Creating Rsvp");
        return guestRepository.save(guests);
    }



}
