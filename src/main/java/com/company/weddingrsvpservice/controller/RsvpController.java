package com.company.weddingrsvpservice.controller;

import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import com.company.weddingrsvpservice.repository.EventRepository;
import com.company.weddingrsvpservice.repository.GuestRepository;
//import com.company.weddingrsvpservice.service.RsvpService;
//import com.company.weddingrsvpservice.viewmodel.EventsViewModel;
//import com.company.weddingrsvpservice.viewmodel.RsvpViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class RsvpController {


    RsvpEvent event = new RsvpEvent();
    RsvpGuests guest = new RsvpGuests();


    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private GuestRepository guestRepository;
//    @Autowired
//    private RsvpService rsvpService;



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

        return foundById;
    }



    @PostMapping("/rsvpEvent")
    @ResponseStatus(value = HttpStatus.CREATED)
    public RsvpEvent createEvent(@RequestBody RsvpEvent event) {

        return eventRepository.save(event);
    }

    @PostMapping("/rsvpGuest")
    @ResponseStatus(value = HttpStatus.CREATED)
    public RsvpGuests createGuest(@RequestBody RsvpGuests guests) {

        return guestRepository.save(guests);
    }

    @PostMapping("/rsvpEvent/addEventGuest")
    @ResponseStatus(value = HttpStatus.CREATED)
    public RsvpEvent createEventAndGuest(@RequestBody RsvpEvent event) {
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
    public Optional<RsvpEvent> findEventById(@PathVariable int id) {
        Optional<RsvpEvent> foundEvent = eventRepository.findById(id);

        if(foundEvent == null) {
            return null;
        } else {
            return foundEvent;
        }
    }

    @PutMapping("/guests/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGuestById (@PathVariable int id, @RequestBody RsvpGuests guests) {
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
    public void updateEventById (@PathVariable int id, @RequestBody RsvpEvent event) {
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



//    @GetMapping("/rsvpGuest/search/{email}")
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<RsvpViewModel> displayByEmail(@RequestBody @PathVariable String email) {
//        List<RsvpViewModel> guestEmail = rsvpService.findAllByEmail(email);
//
//
//
//        return guestEmail;
//    }
//        @GetMapping("/rsvpEvent/{id}")
//        @ResponseStatus(value = HttpStatus.OK)
//        public EventsViewModel getEventsById ( @PathVariable int id){
//
//            EventsViewModel evm = rsvpService.findById(id);
//
//            public RsvpGuests createGuest (@RequestBody RsvpGuests guests){
//                //guest.getGuest_event_id(event.getId());
//                // guest.setGuest_event_id(event.getId());
//
//                return guestRepository.save(guests);
//            }
//
////    @GetMapping("/rsvpGuest/search/{email}")
////    @ResponseStatus(value = HttpStatus.OK)
////    public List<RsvpViewModel> displayByEmail(@PathVariable String email) {
////        List<RsvpViewModel> guestEmail = rsvpService.findAllByEmail(email);
////
////
////        return guestEmail;
////    }
//
//            @GetMapping("/rsvpEvent/{id}")
//            @ResponseStatus(value = HttpStatus.OK)
//            public EventsViewModel getEventsById ( @PathVariable int id){
//                EventsViewModel evm = rsvpService.findById(id);
//
//
//                return evm;
//            }
//
//        }

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



