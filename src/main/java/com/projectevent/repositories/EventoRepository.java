package com.projectevent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectevent.models.EventoModel;

@Repository
public interface EventoRepository extends JpaRepository<EventoModel, String> {
    EventoModel findById(Long id);

}
