package com.nicolas.productosycategorias.productosycategorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nicolas.productosycategorias.productosycategorias.models.Producto;
import com.nicolas.productosycategorias.productosycategorias.models.ProductosCategorias;
import com.nicolas.productosycategorias.productosycategorias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    private MainService service;
    
    @GetMapping("/products/new")
    public String formularioProducto(@ModelAttribute("producto") Producto producto){
        return "newProduct.jsp";
    }

    @PostMapping("/products/new")
    public String nuevoProducto(@Valid @ModelAttribute("producto") Producto producto,BindingResult result){

        if(result.hasErrors()){
            return "newProduct.jsp";
        }
        service.crearProducto(producto);
        return "redirect:/";
    }

    @GetMapping("/products/{idProduct}")
    public String showProduct(@PathVariable("idProduct") Long id,Model m,@ModelAttribute("asociacion")ProductosCategorias prodcate){

        Producto prod = service.getProductoxId(id);
        m.addAttribute("producto", prod);
        m.addAttribute("categorias", service.productoSinCategoria(prod));

        return "showProduct.jsp";
         
    }

    

}
