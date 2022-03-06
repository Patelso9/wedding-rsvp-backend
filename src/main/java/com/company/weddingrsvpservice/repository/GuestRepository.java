package com.company.weddingrsvpservice.repository;

import com.company.weddingrsvpservice.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
    Guest findByUniqueId(String uniqueId);
}
