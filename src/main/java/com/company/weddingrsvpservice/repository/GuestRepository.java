package com.company.weddingrsvpservice.repository;

import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<RsvpGuests, Integer> {
//    List<RsvpGuests> findAllGuestByEmail(String email);

//    RsvpGuests findByEmail(String email);
}
