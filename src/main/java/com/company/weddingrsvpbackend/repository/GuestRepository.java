package com.company.weddingrsvpbackend.repository;

import com.company.weddingrsvpbackend.dto.Guests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guests, Integer> {
}
