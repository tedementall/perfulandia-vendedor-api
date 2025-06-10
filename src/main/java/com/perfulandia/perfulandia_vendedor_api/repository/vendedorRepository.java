package com.perfulandia.perfulandia_vendedor_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.perfulandia.perfulandia_vendedor_api.model.vendedor;

public interface vendedorRepository extends JpaRepository<vendedor, Integer> {
	
}
