package com.perfulandia.perfulandia_vendedor_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.perfulandia.perfulandia_vendedor_api.service.VendedorService;
import com.perfulandia.perfulandia_vendedor_api.dto.VendedorDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {
    @Autowired
    private VendedorService Service;

    @PostMapping
    public ResponseEntity<VendedorDTO> crearVendedor(@RequestBody VendedorDTO vendedorDTO) {
        VendedorDTO nuevoVendedor = Service.crearvendedor(vendedorDTO);
        return ResponseEntity.ok(nuevoVendedor);
    }

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> obtenerTodosVendedores() {
        List<VendedorDTO> vendedores = Service.obtenerTodosVendedores();
        return ResponseEntity.ok(vendedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> obtenerVendedorPorId(@RequestParam Integer id) {
        return Service.obtenerVendedorPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendedorDTO> actualizarVendedor(@PathVariable Integer id, @RequestBody VendedorDTO vendedorDTO) {
        VendedorDTO actualizado = Service.actualizarVendedor(id, vendedorDTO);
        return ResponseEntity.ok(actualizado);
    }
    
    
}
