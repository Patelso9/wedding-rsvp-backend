package com.company.weddingrsvpservice.controller;

import com.company.weddingrsvpservice.exceptions.NotFoundException;
import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import com.company.weddingrsvpservice.repository.EventRepository;
import com.company.weddingrsvpservice.repository.GuestRepository;
//import com.company.weddingrsvpservice.service.RsvpService;
//import com.company.weddingrsvpservice.viewmodel.EventsViewModel;
//import com.company.weddingrsvpservice.viewmodel.RsvpViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@Validated
public class RsvpController {


    RsvpEvent event = new RsvpEvent();
    RsvpGuests guest = new RsvpGuests();


    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private GuestRepository guestRepository;



    @GetMapping("/events")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RsvpEvent> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/guests")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RsvpGuests> getAllGuests() {
        return guestRepository.findAll();
    }

    @GetMapping("/guests/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<RsvpGuests> findGuestById (@PathVariable int id) {
        Optional<RsvpGuests> foundById = guestRepository.findById(id);

        if(foundById == null) {
            throw new NotFoundException("Id's do not match - please enter a valid id.");
        } else {
            return foundById;
        }
    }



    @PostMapping("/rsvpEvent")
    @ResponseStatus(value = HttpStatus.CREATED)
    public RsvpEvent createEvent(@RequestBody @Valid RsvpEvent event) {

        return eventRepository.save(event);
    }

    @PostMapping("/rsvpGuest")
    @ResponseStatus(value = HttpStatus.CREATED)
    public RsvpGuests createGuest(@RequestBody @Valid RsvpGuests guests) {

        return guestRepository.save(guests);
    }

    @PostMapping("/rsvpEvent/addEventGuest")
    @ResponseStatus(value = HttpStatus.CREATED)
    public RsvpEvent createEventAndGuest(@RequestBody @Valid RsvpEvent event) {
        RsvpEvent e = eventRepository.save(event);

        if (!event.getGuests().isEmpty()) {
            Set<RsvpGuests> guests = event.getGuests();
            for (RsvpGuests g : guests) {
                g.setGuestId(e.getId());
                guestRepository.save(g);
            }
        }
        return e;

    }

    @GetMapping("/events/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<RsvpEvent> findEventById(@PathVariable int id) {
        Optional<RsvpEvent> foundEvent = eventRepository.findById(id);

        if(foundEvent == null) {
            throw new NotFoundException("Id's do not match - please enter a valid id.");
        } else {
            return foundEvent;
        }
    }

    @PutMapping("/guests/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGuestById (@PathVariable int id, @RequestBody @Valid RsvpGuests guests) {
        if(guests.getId() != id) {
            throw new IllegalArgumentException("Id's don't match");
        }
        guestRepository.save(guests);
    }

    @DeleteMapping("/guests/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGuestById(@PathVariable int id) {

        guestRepository.deleteById(id);


    }

    @PutMapping("/events/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateEventById (@PathVariable int id, @RequestBody @Valid RsvpEvent event) {
        if(event.getId() != id) {
            throw new IllegalArgumentException("Id's don't match");
        }
        eventRepository.save(event);
    }

    @DeleteMapping("/events/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEventById(@PathVariable int id) {

        eventRepository.deleteById(id);
    }
    
    @GetMapping("/rsvpGuests/{email}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RsvpGuests> searchGuestByEmail(@RequestBody @PathVariable String email) {
        List<RsvpGuests> guests = guestRepository.findAll();
        List<RsvpGuests> newList = null;
        for (RsvpGuests e : guests) {
            if (e.getGuestEmail().equals(email)) {
                e.setId(e.getId());
                newList = Arrays.asList(e);
            }
        }
        return newList;
    }
}





