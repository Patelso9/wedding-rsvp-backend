package com.company.weddingrsvpservice.repository;

import com.company.weddingrsvpservice.model.RsvpGuests;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GuestRepository extends JpaRepository<RsvpGuests, Integer> {
<<<<<<< HEAD

=======
    List<RsvpGuests> findAllGuestByEmail(String email);
>>>>>>> 5abf23f627699e59ea32a4c98d3d73c13fd8434f

}
