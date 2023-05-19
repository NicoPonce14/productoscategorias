package com.nicolas.productosycategorias.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nicolas.productosycategorias.productosycategorias.models.Categoria;
import com.nicolas.productosycategorias.productosycategorias.models.Producto;

public interface CategoryRepo extends CrudRepository<Categoria,Long>{
    List<Categoria> findAll();

    List<Categoria> findByProductsNotContains(Producto producto);
}
