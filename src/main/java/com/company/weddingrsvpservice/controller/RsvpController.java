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
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

=======
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
>>>>>>> 5abf23f627699e59ea32a4c98d3d73c13fd8434f
import java.util.List;

@RestController
@Validated
public class RsvpController {

//    RsvpGuests guest = new RsvpGuests();

    public static List<RsvpEvent> eventsList = new ArrayList<>(Arrays.asList(
            new RsvpEvent(1, "Mehndi", "New York"),
            new RsvpEvent(2, "Sangeet", "Chicago"),
            new RsvpEvent(3, "Reception", "LA")
    ));





    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private RsvpService rsvpService;



    @GetMapping("/events/{email}")
    @ResponseStatus(value = HttpStatus.OK)
    public RsvpEvent findEvents(@PathVariable String email) {
        guestRepository.findAllGuestByEmail(email);

        return null;
    }


    @PostMapping("/rsvpEvent")
    @ResponseStatus(value = HttpStatus.CREATED)
    public RsvpEvent createEvent(@RequestBody RsvpEvent event){
        //guest.getGuest_event_id(event.getId());
        // guest.setGuest_event_id(event.getId());

         return eventRepository.save(event);
    }

    @PostMapping("/rsvpGuest")
<<<<<<< HEAD
    @ResponseStatus(value = HttpStatus.CREATED)
    public RsvpGuests createGuest(@RequestBody  RsvpGuests guests){
=======
    @ResponseStatus(HttpStatus.CREATED)
    public RsvpGuests createEvent(@RequestBody @Valid RsvpGuests guests){
>>>>>>> 5abf23f627699e59ea32a4c98d3d73c13fd8434f
        //guest.getGuest_event_id(event.getId());
        // guest.setGuest_event_id(event.getId());

        return guestRepository.save(guests);
    }
<<<<<<< HEAD
    @GetMapping("/rsvpGuest/search/{email}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RsvpViewModel> displayByEmail(@RequestBody @PathVariable String email) {
        List<RsvpViewModel> guestEmail = rsvpService.findAllByEmail(email);
=======




>>>>>>> 5abf23f627699e59ea32a4c98d3d73c13fd8434f


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

