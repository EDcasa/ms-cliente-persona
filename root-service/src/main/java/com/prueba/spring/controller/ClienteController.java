package com.prueba.spring.controller;


import com.prueba.spring.postgres.entity.ClienteEntity;
import com.prueba.spring.service.IClienteService;
import com.prueba.spring.vo.request.ClienteVo;
import com.prueba.spring.vo.response.GeneralResponseVo;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author ecasa on 2024/05/02.
 * @version 1.0.0
 */
@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "Bearer")
public class ClienteController {

    private final transient IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //CRUD
    @GetMapping(value = "/obtenerCliente", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> obtener(){
        return null;
    }

    //crear editar actualizar eliminar
    @PostMapping(value = "/crearCliente", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> crear(@RequestBody ClienteVo cliente){
        GeneralResponseVo response = clienteService.crearCliente(cliente);
        return new ResponseEntity<>(response, response.getStatus().equals("SUCCESS") ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/editarCliente", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> editar(@RequestBody String movimiento){
        return null;
    }

    @DeleteMapping(value = "/eliminarCliente", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> eliminar(@RequestBody String movimiento){
        return null;
    }

}
