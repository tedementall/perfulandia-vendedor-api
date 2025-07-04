package com.perfulandia.perfulandia_vendedor_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorDTO extends RepresentationModel<VendedorDTO> {
    private Integer id_vendedor;
    private Integer id_usuario;
    private String nombre_completo;
    private String rut;
    private String area_ventas;
public Integer getId() {
    return this.id_vendedor;
}
}

