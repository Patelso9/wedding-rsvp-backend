package com.company.weddingrsvpservice.service;

import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import com.company.weddingrsvpservice.repository.EventRepository;
import com.company.weddingrsvpservice.repository.GuestRepository;
import com.company.weddingrsvpservice.viewmodel.EventsViewModel;
<<<<<<< HEAD
//import com.company.weddingrsvpservice.viewmodel.RsvpViewModel;

=======
import com.company.weddingrsvpservice.viewmodel.RsvpViewModel;
>>>>>>> a12445ca8d1761347c463130c4770d8d3af6bb76
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

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
//        RsvpViewModel guestsList = (RsvpViewModel) findAllByEmail(guestEmail);
//
//        //Assemble the RsvpViewModel
//        RsvpViewModel rvm = new RsvpViewModel();
//        rvm.setId(event.getId());
//        rvm.setGuest_event_id(event.getId());
//        rvm.setEventName(event.getEventName());
//        rvm.setLocation(event.getLocation());
//        rvm.setGuestEmail(guest.getGuestEmail());
//        rvm.setAttending(guest.getAttending());
//       // rvm.setGuests(guestsList);
//        return rvm;
//
//    }
<<<<<<< HEAD

//    @Transactional
//    public RsvpViewModel buildRsvpViewModel1(String guestEmail){
//
//        List<RsvpViewModel> guestsList = findAllByEmail(guestEmail);
//
//        //Assemble the RsvpViewModel
//        RsvpViewModel rvm = new RsvpViewModel();
//        rvm.setId(event.getId());
//        rvm.setGuest_event_id(event.getId());
//        rvm.setEventName(event.getEventName());
//        rvm.setLocation(event.getLocation());
//        rvm.setGuestEmail(guest.getGuestEmail());
//        rvm.setAttending(guest.getAttending());
//       // rvm.setGuests(guestsList);
//        return rvm;

//    }
=======
>>>>>>> a12445ca8d1761347c463130c4770d8d3af6bb76
    private EventsViewModel buildEventViewModel(RsvpEvent events) {

        // Get the associated artist
        Optional<RsvpGuests> guests = guestRepository.findById(1);

        System.out.println(guests);

        // Assemble the AlbumViewModel
        EventsViewModel evm = new EventsViewModel();
        evm.setId(events.getId());
        evm.setEventName(events.getEventName());
        evm.setLocation(events.getLocation());
        evm.setGuests(guests.get());

        return evm;
    }

     public EventsViewModel findById(int id){
         Optional<RsvpEvent> events = eventRepository.findById(id);
         return events.isPresent() ? buildEventViewModel(events.get()) : null;


     }
<<<<<<< HEAD
//    public RsvpViewModel findByEmail(String guestEmail){
////    @Transactional
////     private RsvpViewModel buildRsvpViewModel(RsvpEvent event){
////
////         List<RsvpGuests> eventList = guestRepository.findAllGuestByEmail();
////           RsvpViewModel rvm = new RsvpViewModel();
////           rvm.setId(event.getId());
////
////
////
////           rvm.setDescription(event.getDescription());
////           rvm.setTotalAttending(event.getTotalAttending());
////
////           rvm.setEventList(eventList);
////
////           return  rvm;
////    }
//
//    public RsvpViewModel findEvent(int id) {
//
//        Optional<RsvpEvent> events = eventRepository.findById(id);
=======
     //FUNCTIONS CRUD
     //Add
     //Update
    //Delete
    //View All events
    //View all events by Id
    //View all guest by event Id


//    public List<EventsViewModel> findAllByEmail(String guestEmail) {
//       RsvpGuests foundGuest = null;
//        List<RsvpGuests> guestsList = guestRepository.findAll();
//        List<EventsViewModel> evm = Collections.singletonList(new EventsViewModel());
//        for (RsvpGuests guests : guestsList) {
//                //validates
//            if (guests.getGuestEmail().equals(guestEmail)) {
//
//                //if(!event.getGuests().isEmpty()){
//                    Set<RsvpGuests> guests1 = (Set<RsvpGuests>) guests;
//                    for(RsvpGuests g : guests1){
//                        if(g.getId() == event.getId())
//                            foundGuest = g;
//                        evm.add(foundGuest);
//                        break;
//                            //g.setGuestId(event.getId());
//
//                    }
//                //}
>>>>>>> a12445ca8d1761347c463130c4770d8d3af6bb76
//
//            }
//
//        }
//        if (!foundGuest) {
//            try {
//                throw new ClassNotFoundException("Email not Found");
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        return evm;
<<<<<<< HEAD
//    }
//

//
//        boolean found = false;
//        List<RsvpGuests> guests = guestRepository.findAll();
//        for(RsvpGuests guest : guests){
//            if(guest.getGuestEmail().equals(guestEmail)){
//               // RsvpViewModel rvm = buildRsvpViewModel1(String.valueOf(guest.getGuestEmail()));
//                found = true;
=======
>>>>>>> a12445ca8d1761347c463130c4770d8d3af6bb76
//
//    }
<<<<<<< HEAD
//    public List<RsvpViewModel> findAllByEmail(String guestEmail) {
//        List<RsvpGuests> guestsList = guestRepository.findAll();
//        List<RsvpViewModel> avmList = new ArrayList<>();
//
//        // int index = 0;
//        boolean found = false;
//        for (RsvpGuests guests : guestsList) {
//
//            if (guests.getGuestEmail().equals(guestEmail)) {
//
//                RsvpViewModel rvm = buildRsvpViewModel1(String.valueOf(guests.getGuestEmail()));
//                avmList.add(rvm);
//                found = true;
//                break;
//
//
//            }
//
//            // index ++;
//        }
//        if (!found) {
//            try {
//                throw new ClassNotFoundException("Email not Found");
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        return found ? Collections.singletonList(buildRsvpViewModel1(guest.getGuestEmail())) : null;
//
//    }
=======
>>>>>>> a12445ca8d1761347c463130c4770d8d3af6bb76
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







