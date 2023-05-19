package com.nicolas.productosycategorias.productosycategorias.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nicolas.productosycategorias.productosycategorias.models.ProductosCategorias;

public interface ProductsCategoriesRepo extends CrudRepository<ProductosCategorias,Long> {
    
}
