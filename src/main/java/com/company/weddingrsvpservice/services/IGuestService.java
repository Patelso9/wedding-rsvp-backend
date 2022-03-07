package com.company.weddingrsvpservice.services;

import com.company.weddingrsvpservice.model.Guest;

import java.util.Optional;

public interface IGuestService {
    Guest findByUniqueId(String uniqueId);
    Guest acceptGuest(Guest guest, String guestName, String messageFromGuest, String email );
    Guest declineGuest(Guest guest, String messageFromGuest);
    Guest save(Guest guest);
    Optional<Guest> findOne(Integer id);
}
