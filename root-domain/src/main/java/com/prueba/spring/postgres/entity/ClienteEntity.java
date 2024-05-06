package com.prueba.spring.postgres.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Entity Cuenta
 * @author ecasa on 2024/05/02.
 * @version 1.0.0
 */

@Entity
@Data
@Table(name = "cliente", schema = "public")
//@PrimaryKeyJoinColumn(name = "personaid")
public class ClienteEntity{

    //herencia de persona
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clienteid", nullable = false)
    private Integer clienteId;

    @Column(name = "clave", nullable = false, length = 50)
    private String clave;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @OneToOne
    @JoinColumn(name = "personaid")
    private PersonaEntity persona;

}
