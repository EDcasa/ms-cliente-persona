/*
 * Copyright (c) 2021.
 *
 * Superintendencia de Econom&iacute;a Popular y Solidaria
 * Todos los derechos reservados
 */

package com.prueba.spring.controller;

import com.prueba.spring.service.IPersonaService;
import com.prueba.spring.vo.request.PersonaVo;
import com.prueba.spring.vo.response.GeneralResponseVo;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author ecasa on 2024/05/02.
 * @version 1.0.0
 */
@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "Bearer")
public class PersonaController {

    private final transient IPersonaService personaService;

    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping(value = "/obtenerPersona", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> obtener() {
        return null;
    }

    //crear editar actualizar eliminar
    @PostMapping(value = "/crearPersona", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> crear(@RequestBody PersonaVo persona) {
        GeneralResponseVo response = personaService.crearPersona(persona);
        return new ResponseEntity<>(response, response.getStatus().equals("SUCCESS") ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/editarPersona", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> editar(@RequestBody String movimiento) {
        return null;
    }

    @DeleteMapping(value = "/eliminarPersona", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> eliminar(@RequestBody String movimiento) {
        return null;
    }
}
