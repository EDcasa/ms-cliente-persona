package com.prueba.spring.postgres.repository;

import com.prueba.spring.postgres.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepository extends JpaRepository<PersonaEntity, Integer> {
}
