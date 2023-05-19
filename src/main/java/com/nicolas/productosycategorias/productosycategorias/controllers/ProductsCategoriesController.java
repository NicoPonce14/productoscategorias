package com.nicolas.productosycategorias.productosycategorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.nicolas.productosycategorias.productosycategorias.models.ProductosCategorias;
import com.nicolas.productosycategorias.productosycategorias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class ProductsCategoriesController {
    @Autowired
    private MainService service;
    
    @PostMapping("/aso/{idProduct}")
    public String enalazarProducto(@PathVariable("idProduct")Long id, @Valid @ModelAttribute("asociacion") ProductosCategorias prodcate,BindingResult result){
        if(result.hasErrors()){
            return "showProduct.jsp";
        }
        service.crearVinculo(prodcate);
        return "redirect:/products/"+id;
    }

    @PostMapping("/asos/{idC}")
    public String enalazarCategoria(@PathVariable("idC")Long id, @Valid @ModelAttribute("asoci") ProductosCategorias prodcate,BindingResult result){
        if(result.hasErrors()){
            return "showCategory.jsp";
        }
        service.crearVinculo(prodcate);
        return "redirect:/categories/"+id;
    }
}
