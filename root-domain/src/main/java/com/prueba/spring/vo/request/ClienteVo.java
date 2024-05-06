package com.prueba.spring.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 *
 * @autor: Created by David on 2021/05/02.
 * @version: 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteVo extends PersonaVo {
    private Integer clienteId;
    private String clave;
    private Boolean estado;
}
