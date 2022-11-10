package com.projectevent.models;

// import javax.persistence.CascadeType;

// import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

// import org.hibernate.annotations.OnDelete;
// import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ConvidadoModel {

    @Id
    @NotEmpty
    private String cpf;
    @NotEmpty
    private String nomeConvidado;

    @ManyToOne
    private EventoModel evento;

}
