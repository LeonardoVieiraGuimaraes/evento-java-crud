package com.projectevent.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.projectevent.models.ConvidadoModel;
import com.projectevent.models.EventoModel;

@Repository
public interface ConvidadoRepository extends JpaRepository<ConvidadoModel, String> {

    List<ConvidadoModel> findByEvento(EventoModel evento);

    ConvidadoModel findByCpf(String cpf);
}
