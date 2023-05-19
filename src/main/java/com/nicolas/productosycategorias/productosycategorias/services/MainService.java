package com.nicolas.productosycategorias.productosycategorias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.productosycategorias.productosycategorias.models.Categoria;
import com.nicolas.productosycategorias.productosycategorias.models.Producto;
import com.nicolas.productosycategorias.productosycategorias.models.ProductosCategorias;
import com.nicolas.productosycategorias.productosycategorias.repositories.CategoryRepo;
import com.nicolas.productosycategorias.productosycategorias.repositories.ProductRepo;
//import com.nicolas.productosycategorias.productosycategorias.repositories.ProductsCategoriesRepo;
import com.nicolas.productosycategorias.productosycategorias.repositories.ProductsCategoriesRepo;

@Service
public class MainService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductsCategoriesRepo  productsCategoriesRepo;

    //SERVICIOS PARA PRODUCTO
    public Producto crearProducto(Producto prod){
        return productRepo.save(prod);
    }
    public List<Producto> todosProd(){
        return productRepo.findAll();
    }

    public Producto getProductoxId(Long id){
        return productRepo.findById(id).orElse(null);
    }

    public List<Producto> categoriaSinproducto(Categoria categoria){
		return productRepo.findByCategoriesNotContains(categoria);
	}

    

    //SERVICIOS PARA CATEGORIA
    public Categoria crearCategoria(Categoria cat){
        return categoryRepo.save(cat);
    }
    public Categoria getcategoriaxId(Long id){
        return categoryRepo.findById(id).orElse(null);
    }

    public List<Categoria> todosCateg(){
        return categoryRepo.findAll();
    }
    public List<Categoria> productoSinCategoria(Producto producto){
		return categoryRepo.findByProductsNotContains(producto);
	}

    //SERVICIOS TABLA INTERMEDIA
    public ProductosCategorias crearVinculo(ProductosCategorias prodcat){
        return productsCategoriesRepo.save(prodcat);
    }
}
