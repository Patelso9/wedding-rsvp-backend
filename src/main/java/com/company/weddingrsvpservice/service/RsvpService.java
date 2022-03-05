package com.company.weddingrsvpservice.service;

import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import com.company.weddingrsvpservice.repository.EventRepository;
import com.company.weddingrsvpservice.repository.GuestRepository;
import com.company.weddingrsvpservice.viewmodel.RsvpViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class RsvpService {
    private EventRepository eventRepository;
    private GuestRepository guestRepository;

    @Autowired
    public  RsvpService(EventRepository eventRepository, GuestRepository guestRepository){
        this.eventRepository = eventRepository;
        this.guestRepository = guestRepository;
    }
    @Transactional
    public RsvpViewModel saveEvent(RsvpViewModel rsvpViewModel){

        RsvpEvent event = new RsvpEvent();
        //Getting guest ID
        event.setGuestId(rsvpViewModel.getRsvpGuests().getId());
        event.setGuestName(rsvpViewModel.getGuestName());
        event.setTotalAttending(rsvpViewModel.getTotalAttending());
        event.setDescription(rsvpViewModel.getDescription());
        event = eventRepository.save(event);
        rsvpViewModel.setId(event.getId());

        List<RsvpGuests> eventList = Collections.singletonList(rsvpViewModel.getRsvpGuests());

        eventList.stream()
                .forEach(t -> {
                    t.setEvent_id(rsvpViewModel.getId());
                    guestRepository.save(t);
                });

        eventList = guestRepository.findAllGuestByGuestId(rsvpViewModel.getId());
        rsvpViewModel.setRsvpGuests(eventList);





        return  rsvpViewModel;


    }





}
