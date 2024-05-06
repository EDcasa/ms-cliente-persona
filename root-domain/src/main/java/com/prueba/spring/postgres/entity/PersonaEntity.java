package com.prueba.spring.postgres.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Entity Persona
 * @author ecasa on 2024/05/02.
 * @version 1.0.0
 */
@Entity
@Data
@Table(name = "persona", schema = "public")
//@Inheritance(strategy = InheritanceType.JOINED)
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personaid", nullable = false)
    private Integer personaId;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "genero", nullable = false, length = 50)
    private String genero;

    @Column(name = "edad", nullable = false, length = 50)
    private Integer edad;

    @Column(name = "identificacion", nullable = false, length = 50)
    private String identificacion;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;
}
