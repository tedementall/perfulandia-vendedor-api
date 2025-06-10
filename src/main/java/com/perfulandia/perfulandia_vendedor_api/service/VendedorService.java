package com.perfulandia.perfulandia_vendedor_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.perfulandia_vendedor_api.dto.VendedorDTO;
import com.perfulandia.perfulandia_vendedor_api.model.vendedor;
import com.perfulandia.perfulandia_vendedor_api.repository.vendedorRepository;

@Service
public class VendedorService {
    @Autowired
    private vendedorRepository repository;

    public VendedorDTO crearvendedor (VendedorDTO vendedorDTO) {
        vendedor vendedor = toEntity(vendedorDTO);
        vendedor savedVendedor = repository.save(vendedor);
        return toDto(savedVendedor);
    }

    public List<VendedorDTO> obtenerTodosVendedores() {
        return  repository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public Optional<VendedorDTO> obtenerVendedorPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDto);
    }

    public VendedorDTO actualizarVendedor(Integer id, VendedorDTO vendedorDTO) {
        return repository.findById(id)
                .map(existingVendedor -> {
                    existingVendedor.setId_usuario(vendedorDTO.getId_usuario());
                    existingVendedor.setNombre_completo(vendedorDTO.getNombre_completo());
                    existingVendedor.setRut(vendedorDTO.getRut());
                    existingVendedor.setArea_ventas(vendedorDTO.getArea_ventas());
                    vendedor updatedVendedor = repository.save(existingVendedor);
                    return toDto(updatedVendedor);
                })
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado con id: " + id));
    }

    public void eliminarVendedor(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Vendedor no encontrado con id: " + id);
        }
    }

    //metodos auxiliares 

    private VendedorDTO toDto(vendedor vendedor) {
        VendedorDTO dto = new VendedorDTO();
        dto.setId_vendedor(vendedor.getId_vendedor());
        dto.setId_usuario(vendedor.getId_usuario());
        dto.setNombre_completo(vendedor.getNombre_completo());
        dto.setRut(vendedor.getRut());
        dto.setArea_ventas(vendedor.getArea_ventas());
        return dto;
    }

    private vendedor toEntity(VendedorDTO dto) {
        vendedor vendedor = new vendedor();
        vendedor.setId_vendedor(dto.getId_vendedor());
        vendedor.setId_usuario(dto.getId_usuario());
        vendedor.setNombre_completo(dto.getNombre_completo());
        vendedor.setRut(dto.getRut());
        vendedor.setArea_ventas(dto.getArea_ventas());
        return vendedor;
    }
}
