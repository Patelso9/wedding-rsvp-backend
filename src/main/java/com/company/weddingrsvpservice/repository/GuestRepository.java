package com.company.weddingrsvpservice.repository;

import com.company.weddingrsvpservice.model.RsvpGuests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<RsvpGuests, Integer> {

}
