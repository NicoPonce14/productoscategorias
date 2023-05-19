package com.nicolas.productosycategorias.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nicolas.productosycategorias.productosycategorias.models.Categoria;
import com.nicolas.productosycategorias.productosycategorias.models.Producto;

public interface ProductRepo extends CrudRepository<Producto,Long> {
    List<Producto> findAll();
    List<Producto> findByCategoriesNotContains(Categoria categoria);
    
}
