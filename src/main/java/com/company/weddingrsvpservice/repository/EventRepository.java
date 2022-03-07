package com.company.weddingrsvpservice.repository;

import com.company.weddingrsvpservice.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Integer> {
}
