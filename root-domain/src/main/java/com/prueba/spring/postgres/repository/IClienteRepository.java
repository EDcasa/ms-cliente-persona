package com.prueba.spring.postgres.repository;

import com.prueba.spring.postgres.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que permite la comunicación con la base de datos de la tabla cliente.
 * Implementa las operaciones básicas de un CRUD.
 */
@Repository
public interface IClienteRepository extends CrudRepository<ClienteEntity, Integer> {
}
