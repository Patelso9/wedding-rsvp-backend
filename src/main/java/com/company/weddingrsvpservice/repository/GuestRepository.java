package com.company.weddingrsvpservice.repository;

import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GuestRepository extends JpaRepository<RsvpGuests, Integer> {

<<<<<<< HEAD
//    List<RsvpGuests> findAllGuestByEmail(String email);
=======
>>>>>>> a12445ca8d1761347c463130c4770d8d3af6bb76

//    List<RsvpGuests> findAllGuestByEmail(String email);

//    RsvpGuests findByEmail(String email);
}
