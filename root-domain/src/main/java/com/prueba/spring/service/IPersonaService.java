package com.prueba.spring.service;

import com.prueba.spring.vo.request.PersonaVo;
import com.prueba.spring.vo.response.GeneralResponseVo;
import org.springframework.stereotype.Service;

/**
 * Interfaz para la clase persona
 */
public interface IPersonaService {

    /**
     * Metodo para crear una persona
     *
     * @param persona
     * @return
     */
    GeneralResponseVo crearPersona(PersonaVo persona);
}
