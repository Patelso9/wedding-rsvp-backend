//package com.company.weddingrsvpservice.service;
//
//import com.company.weddingrsvpservice.model.RsvpEvent;
//import com.company.weddingrsvpservice.model.RsvpGuests;
//import com.company.weddingrsvpservice.repository.EventRepository;
//import com.company.weddingrsvpservice.repository.GuestRepository;
//import com.company.weddingrsvpservice.viewmodel.RsvpViewModel;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import org.springframework.transaction.annotation.Transactional;
//
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class RsvpService {
//    private EventRepository eventRepository;
//    private GuestRepository guestRepository;
//
//    @Autowired
//    public  RsvpService(EventRepository eventRepository, GuestRepository guestRepository){
//        this.eventRepository = eventRepository;
//        this.guestRepository = guestRepository;
//    }
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
//
//
//
//
//
//}
