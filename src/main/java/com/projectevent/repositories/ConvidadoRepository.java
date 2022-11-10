package com.projectevent.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectevent.models.ConvidadoModel;
import com.projectevent.models.EventoModel;

@Repository
public interface ConvidadoRepository extends CrudRepository<ConvidadoModel, String> {

    Iterable<ConvidadoModel> findByEvento(EventoModel evento);

    ConvidadoModel findByCpf(String cpf);
}
