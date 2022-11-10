package com.projectevent.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectevent.models.EventoModel;

@Repository
public interface EventoRepository extends CrudRepository<EventoModel, String> {
    EventoModel findByCodigo(long codigo);

}
