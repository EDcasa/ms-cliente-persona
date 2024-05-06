package com.prueba.spring.api.service;

import com.prueba.spring.postgres.entity.ClienteEntity;
import com.prueba.spring.postgres.entity.PersonaEntity;
import com.prueba.spring.postgres.repository.IClienteRepository;
import com.prueba.spring.service.IClienteService;
import com.prueba.spring.service.IPersonaService;
import com.prueba.spring.vo.request.ClienteVo;
import com.prueba.spring.vo.request.PersonaVo;
import com.prueba.spring.vo.response.GeneralResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ClienteService implements IClienteService {

    private final transient IClienteRepository clienteRepository;
    private final transient IPersonaService personaService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ClienteService(IClienteRepository clienteRepository, IPersonaService personaService) {
        this.clienteRepository = clienteRepository;
        this.personaService = personaService;
    }

    /**
     * Metodo para crear un cliente con herencia de la clase persona
     *
     * @param cliente
     * @return
     */
    @Override
    public GeneralResponseVo crearCliente(ClienteVo cliente) {
        try {
            GeneralResponseVo response = personaService.crearPersona(cliente);
            if (response.getStatus().equals("SUCCESS")) {
                PersonaEntity persona = (PersonaEntity) response.getData();
                ClienteEntity clienteEntity = new ClienteEntity();
                clienteEntity.setPersona(persona);
                clienteEntity.setClave(passwordEncoder.encode(cliente.getClave()));
                clienteEntity.setEstado(cliente.getEstado());
                //clienteEntity.setDireccion(cliente.getDireccion());
                //clienteEntity.setTelefono(cliente.getTelefono());
                //clienteEntity.setIdentificacion(cliente.getIdentificacion());
                //clienteEntity.setEdad(cliente.getEdad());
                //clienteEntity.setGenero(cliente.getGenero());
                //clienteEntity.setNombre(cliente.getNombre());
                clienteRepository.save(clienteEntity);
                return new GeneralResponseVo("Cliente creado correctamente", clienteEntity, "SUCCESS");
            } else {
                return new GeneralResponseVo("Error al crear el cliente", response.getData(), "ERROR");
            }
        } catch (Exception e) {
            return new GeneralResponseVo(e.getMessage(), cliente, "ERROR");
        }
    }
}
