package com.company.weddingrsvpservice.service;

import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import com.company.weddingrsvpservice.repository.EventRepository;

import com.company.weddingrsvpservice.repository.GuestRepository;
import com.company.weddingrsvpservice.viewmodel.EventsViewModel;
import com.company.weddingrsvpservice.viewmodel.RsvpViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class RsvpService {
    private EventRepository eventRepository;
    private GuestRepository guestRepository;
    RsvpEvent event = new RsvpEvent();
    RsvpGuests guest = new RsvpGuests();

    @Autowired
    public  RsvpService(EventRepository eventRepository, GuestRepository guestRepository){
        this.eventRepository = eventRepository;
        this.guestRepository = guestRepository;

    }


//    @Transactional
//    public RsvpViewModel buildRsvpViewModel1(String guestEmail){
//
//        List<RsvpViewModel> guestsList = findAllByEmail(guest.getGuestEmail());
//
//      //Assemble the RsvpViewModel
//        RsvpViewModel rvm = new RsvpViewModel();
//        rvm.setId(event.getId());
//        rvm.setGuest_event_id(event.getId());
//        rvm.setEventName(event.getEventName());
//        rvm.setLocation(event.getLocation());
//        rvm.setGuestEmail(guest.getGuestEmail());
//        rvm.setAttending(guest.getAttending());
//        rvm.setGuests(guestsList);
//        return rvm;
//
//    }
    @Transactional
    public RsvpViewModel buildRsvpViewModel1(String guestEmail){

        List<RsvpViewModel> guestsList = findAllByEmail(guestEmail);

        //Assemble the RsvpViewModel
        RsvpViewModel rvm = new RsvpViewModel();
        rvm.setId(event.getId());
        rvm.setGuest_event_id(event.getId());
        rvm.setEventName(event.getEventName());
        rvm.setLocation(event.getLocation());
        rvm.setGuestEmail(guest.getGuestEmail());
        rvm.setAttending(guest.getAttending());
       // rvm.setGuests(guestsList);
        return rvm;

    }
    private EventsViewModel buildEventViewModel(RsvpEvent events) {

        // Get the associated artist
        Optional<RsvpGuests> guests = guestRepository.findById(events.getId());


        // Assemble the AlbumViewModel
        EventsViewModel evm = new EventsViewModel();
        evm.setId(events.getId());
        evm.setEventName(events.getEventName());
        evm.setLocation(events.getLocation());
       // evm.setGuests(guests.get());

        return evm;
    }

     public EventsViewModel findById(int id){
         Optional<RsvpEvent> events = eventRepository.findById(id);
         return events.isPresent() ? buildEventViewModel(events.get()) : null;


     }
//    public RsvpViewModel findByEmail(String guestEmail){
//
//        boolean found = false;
//        List<RsvpGuests> guests = guestRepository.findAll();
//        for(RsvpGuests guest : guests){
//            if(guest.getGuestEmail().equals(guestEmail)){
//               // RsvpViewModel rvm = buildRsvpViewModel1(String.valueOf(guest.getGuestEmail()));
//                found = true;
//
//                //avmList.add(rvm);
//                // = true;
//               // break;
//            }
//        }return found ? buildRsvpViewModel1(guest.getGuestEmail()) : null;
//    }
    public List<RsvpViewModel> findAllByEmail(String guestEmail) {
        List<RsvpGuests> guestsList = guestRepository.findAll();
        List<RsvpViewModel> avmList = new ArrayList<>();

        // int index = 0;
        boolean found = false;
        for (RsvpGuests guests : guestsList) {

            if (guests.getGuestEmail().equals(guestEmail)) {

                RsvpViewModel rvm = buildRsvpViewModel1(String.valueOf(guests.getGuestEmail()));
                avmList.add(rvm);
                found = true;
                break;


            }

            // index ++;
        }
        if (!found) {
            try {
                throw new ClassNotFoundException("Email not Found");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return found ? Collections.singletonList(buildRsvpViewModel1(guest.getGuestEmail())) : null;

    }
        public void saveGuest(RsvpGuests guest){
         guestRepository.save(guest);
        }


}
//    private int id;
//    private int guest_event_id;
//    private RsvpGuests guests;
//    private String eventName;
//    private String location;
//    private String guestEmail;
//    private Integer attending;

//    @Transactional
//     private RsvpViewModel buildRsvpViewModel(RsvpEvent event){
//
//         List<RsvpGuests> eventList = guestRepository.findAllGuestByEmail(guest.getGuestEmail());
//           RsvpViewModel rvm = new RsvpViewModel();
//
//
//           return  rvm;
//    }







