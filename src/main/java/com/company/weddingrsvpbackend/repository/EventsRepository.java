package com.company.weddingrsvpbackend.repository;

import com.company.weddingrsvpbackend.dto.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {
}
