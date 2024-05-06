package com.prueba.spring.service;

import com.prueba.spring.vo.request.ClienteVo;
import com.prueba.spring.vo.response.GeneralResponseVo;

public interface IClienteService {

    /**
     * Metodo para crear un cliente con herencia de la clase persona
     * @param cliente
     * @return
     */
    GeneralResponseVo crearCliente(ClienteVo cliente);

}
