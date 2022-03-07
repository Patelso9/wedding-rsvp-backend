package com.company.weddingrsvpservice.controller;

import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import com.company.weddingrsvpservice.repository.EventRepository;
import com.company.weddingrsvpservice.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RsvpController {

    RsvpEvent event = new RsvpEvent();
    RsvpGuests guest = new RsvpGuests();

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private GuestRepository guestRepository;
    @PostMapping("/rsvpEvent")
    @ResponseStatus(HttpStatus.CREATED)
    public RsvpEvent createEvent(@RequestBody @Valid RsvpEvent event){
         guest.setGuest_event_id(event.getId());
         
         return eventRepository.save(event);
    }


}
