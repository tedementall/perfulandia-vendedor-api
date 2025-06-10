package com.perfulandia.perfulandia_vendedor_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vendedores")
@Data

public class vendedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_vendedor;

    private Integer id_usuario;

    private String nombre_completo;

    private String rut;

    private String area_ventas;
    
}
