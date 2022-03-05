package com.company.weddingrsvpservice.service;

import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import com.company.weddingrsvpservice.repository.EventRepository;
import com.company.weddingrsvpservice.repository.GuestRepository;
import com.company.weddingrsvpservice.viewmodel.RsvpViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RsvpService {
    private EventRepository eventRepository;
    private GuestRepository guestRepository;

    @Autowired
    public  RsvpService(EventRepository eventRepository, GuestRepository guestRepository){
        this.eventRepository = eventRepository;
        this.guestRepository = guestRepository;
    }





    //Helper Method
    private RsvpViewModel buildRsvpViewModel(RsvpEvent event){
        // Get the associated guest
        Optional<RsvpGuests> guest = guestRepository.findById(event.getGuestId());

        List<RsvpGuests> eventList = eventRepository.findAllEventByGuestEmail(event.getGuestEmail());

        //Assemble view model
       RsvpViewModel rvm = new RsvpViewModel();
       rvm.setId(event.getId());
       rvm.setGuestName(event.getGuestName());
       rvm.setGuestEmail(event.getGuestEmail());
       rvm.setTotalAttending(event.getTotalAttending());
       rvm.setDescription(event.getDescription());
       rvm.setEventList(eventList);

       return rvm;
   }
}
