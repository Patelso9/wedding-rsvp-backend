package com.company.weddingrsvpservice.repository;

import com.company.weddingrsvpservice.model.RsvpGuests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.company.weddingrsvpservice.model.RsvpEvent;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<RsvpEvent, Integer> {
    List<RsvpGuests> findAllEventByGuestEmail(String email);
}
