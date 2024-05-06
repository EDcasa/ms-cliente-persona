package com.prueba.spring.api.service;

import com.prueba.spring.postgres.entity.PersonaEntity;
import com.prueba.spring.postgres.repository.IPersonaRepository;
import com.prueba.spring.service.IPersonaService;
import com.prueba.spring.vo.request.PersonaVo;
import com.prueba.spring.vo.response.GeneralResponseVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaService implements IPersonaService {

    private final transient IPersonaRepository personaRepository;

    public PersonaService(IPersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    /**
     * Metodo para crear una persona
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public GeneralResponseVo crearPersona(PersonaVo persona) {
        try{
            PersonaEntity personaEntity = new PersonaEntity();
            personaEntity.setNombre(persona.getNombre());
            personaEntity.setGenero(persona.getGenero());
            personaEntity.setEdad(persona.getEdad());
            personaEntity.setIdentificacion(persona.getIdentificacion());
            personaEntity.setDireccion(persona.getDireccion());
            personaEntity.setTelefono(persona.getTelefono());
            personaRepository.save(personaEntity);
            return new GeneralResponseVo("Persona creada correctamente", personaEntity, "SUCCESS");
        } catch (Exception e) {
            return new GeneralResponseVo("Error al crear la persona", persona, "ERROR");
        }

    }
}
