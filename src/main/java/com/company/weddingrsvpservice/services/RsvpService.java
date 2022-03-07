package com.company.weddingrsvpservice.services;

import com.company.weddingrsvpservice.model.Guest;
import com.company.weddingrsvpservice.repository.EventRepository;
import com.company.weddingrsvpservice.repository.GuestRepository;
import com.company.weddingrsvpservice.util.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class RsvpService implements IGuestService{

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private EventRepository eventRepository;



    @Override
    public Guest findByUniqueId(String uniqueId) {
        if (uniqueId != null && uniqueId.length() > 0) {
            return this.guestRepository.findByUniqueId(uniqueId);
        }
        return null;
    }

    @Override
    public Guest acceptGuest(Guest guest, String guestName, String messageFromGuest, String email) {
        //Status Condition
        if (guest.getGuestStatus() == StatusEnum.WAITING) {
            messageFromGuest = checkMessageFromGuest(messageFromGuest);
            guest.setGuestName(guestName);
            guest.setMessageFromGuest(messageFromGuest);
            guest.setGuestStatus(StatusEnum.ACCEPTED);
        }


        return this.guestRepository.save(guest);
    }

    private String checkMessageFromGuest(String messageFromGuest) {
        if (messageFromGuest.equalsIgnoreCase("null")) {
            messageFromGuest = null;
        }
        return messageFromGuest;
    }

    @Override
    @Transactional
    public Guest declineGuest(Guest guest, String messageFromGuest) {
        if (guest.getGuestStatus() == StatusEnum.WAITING) {
            messageFromGuest = checkMessageFromGuest(messageFromGuest);
            guest.setMessageFromGuest(messageFromGuest);
            guest.setGuestStatus(StatusEnum.DECLINED);
        }

        return this.guestRepository.save(guest);
    }


    @Override
    @Transactional
    public Guest save(Guest guest) {
        return this.guestRepository.saveAndFlush(guest);
    }

    @Override
    public Optional<Guest> findOne(Integer id) {
        if (id != null) {
            Optional<Guest> guest = guestRepository.findById(id);
            return guest;
        }
        return null;
    }


}
