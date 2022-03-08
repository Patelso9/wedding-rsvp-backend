package com.company.weddingrsvpservice.controller;

import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import com.company.weddingrsvpservice.repository.EventRepository;
import com.company.weddingrsvpservice.repository.GuestRepository;
import com.company.weddingrsvpservice.service.RsvpService;
import com.company.weddingrsvpservice.viewmodel.EventsViewModel;
import com.company.weddingrsvpservice.viewmodel.RsvpViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RsvpController {

    RsvpEvent event = new RsvpEvent();
    RsvpGuests guest = new RsvpGuests();





    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private RsvpService rsvpService;



    @PostMapping("/rsvpEvent")
    @ResponseStatus(value = HttpStatus.CREATED)
    public RsvpEvent createEvent(@RequestBody RsvpEvent event){
        //guest.getGuest_event_id(event.getId());
        // guest.setGuest_event_id(event.getId());

         return eventRepository.save(event);
    }

    @PostMapping("/rsvpGuest")
    @ResponseStatus(value = HttpStatus.CREATED)
    public RsvpGuests createGuest(@RequestBody  RsvpGuests guests){
        //guest.getGuest_event_id(event.getId());
        // guest.setGuest_event_id(event.getId());

        return guestRepository.save(guests);
    }
    @GetMapping("/rsvpGuest/search/{email}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RsvpViewModel> displayByEmail(@RequestBody @PathVariable String email) {
        List<RsvpViewModel> guestEmail = rsvpService.findAllByEmail(email);


        return guestEmail;
    }
    @GetMapping("/rsvpEvent/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public EventsViewModel getEventsById(@PathVariable int id) {
    EventsViewModel evm = rsvpService.findById(id);

    return evm;
}






        //   List<RsvpGuests> guestsList = (List<RsvpGuests>) guestRepository.findAll();

        //String email_Service = String.valueOf(this.rsvpService.findAllByEmail(email));
//        RsvpGuests found = null;
//        for (RsvpGuests guestEmail : guestsList) {
//            if (email_Service == email) {
//                found = guestEmail;
//                break;
//            }
//        }
//        return found;

    }

