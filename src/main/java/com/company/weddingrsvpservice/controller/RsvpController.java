package com.company.weddingrsvpservice.controller;

import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import com.company.weddingrsvpservice.repository.EventRepository;
import com.company.weddingrsvpservice.repository.GuestRepository;
import com.company.weddingrsvpservice.service.RsvpService;
import com.company.weddingrsvpservice.viewmodel.EventsViewModel;
//import com.company.weddingrsvpservice.viewmodel.RsvpViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class RsvpController {


//    RsvpGuests guest = new RsvpGuests();

//    public static List<RsvpEvent> eventsList = new ArrayList<>(Arrays.asList(
//            new RsvpEvent(1, "Mehndi", "New York"),
//            new RsvpEvent(2, "Sangeet", "Chicago"),
//            new RsvpEvent(3, "Reception", "LA")
//    ));




    RsvpEvent event = new RsvpEvent();
    RsvpGuests guest = new RsvpGuests();



    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private RsvpService rsvpService;




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

//    @GetMapping("/event/{email}")
//    @ResponseStatus(HttpStatus.OK)
//    public RsvpGuests getGuestsList(@PathVariable String guestEmail) {
//        RsvpGuests guestsList = guestRepository.findByEmail(guestEmail);
//
//        if(guestsList == null) {
//            return null;
//        } else {
//            return guestsList;
//        }
//    }


    @PostMapping("/rsvpEvent")
    @ResponseStatus(value = HttpStatus.CREATED)
    public RsvpEvent createEvent(@RequestBody RsvpEvent event) {

        @PostMapping("/rsvpEvent")
        @ResponseStatus(value = HttpStatus.CREATED)
        public RsvpEvent createEvent (@RequestBody RsvpEvent event){
            //guest.getGuest_event_id(event.getId());
            // guest.setGuest_event_id(event.getId());


            return eventRepository.save(event);
        }

        @PostMapping("/rsvpEvent/addEventGuest")
        @ResponseStatus(value = HttpStatus.CREATED)
        public RsvpEvent createEventAndGuest (@RequestBody RsvpEvent event){
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

        @PostMapping("/rsvpGuest")
        @ResponseStatus(value = HttpStatus.CREATED)

        public RsvpGuests createGuest (@RequestBody RsvpGuests guests){

            return guestRepository.save(guests);
        }
//    @GetMapping("/rsvpGuest/search/{email}")
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<RsvpViewModel> displayByEmail(@RequestBody @PathVariable String email) {
//        List<RsvpViewModel> guestEmail = rsvpService.findAllByEmail(email);
//
//
//
//        return guestEmail;
//    }
        @GetMapping("/rsvpEvent/{id}")
        @ResponseStatus(value = HttpStatus.OK)
        public EventsViewModel getEventsById ( @PathVariable int id){

            EventsViewModel evm = rsvpService.findById(id);

            public RsvpGuests createGuest (@RequestBody RsvpGuests guests){
                //guest.getGuest_event_id(event.getId());
                // guest.setGuest_event_id(event.getId());

                return guestRepository.save(guests);
            }

//    @GetMapping("/rsvpGuest/search/{email}")
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<RsvpViewModel> displayByEmail(@PathVariable String email) {
//        List<RsvpViewModel> guestEmail = rsvpService.findAllByEmail(email);
//
//
//        return guestEmail;
//    }

            @GetMapping("/rsvpEvent/{id}")
            @ResponseStatus(value = HttpStatus.OK)
            public EventsViewModel getEventsById ( @PathVariable int id){
                EventsViewModel evm = rsvpService.findById(id);


                return evm;
            }

            @GetMapping("/guest")
            public List<RsvpGuests> getAllGuest () {
                return guestRepository.findAll();
            }

            @GetMapping("/event")
            public List<RsvpEvent> getAllEvent () {
                return eventRepository.findAll();
            }

            @PostMapping("/guest")
            public RsvpGuests addGuest (@RequestBody RsvpGuests guest){
                RsvpGuests c = guestRepository.save(guest);
                //check if populatenotes input
                return c;
            }
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



