package com.nicolas.productosycategorias.productosycategorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nicolas.productosycategorias.productosycategorias.models.Categoria;

import com.nicolas.productosycategorias.productosycategorias.models.ProductosCategorias;
import com.nicolas.productosycategorias.productosycategorias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
    
    @Autowired
    private MainService service;
    
    @GetMapping("/categories/new")
    public String formularioCategoria(@ModelAttribute("categoria") Categoria categoria){
        return "newCategory.jsp";
    }

    @PostMapping("/categories/new")
    public String nuevaCategoria(@Valid @ModelAttribute("categoria") Categoria categoria,BindingResult result){

        if(result.hasErrors()){
            return "newCategory.jsp";
        }
        service.crearCategoria(categoria);
        return "redirect:/";
    }

    @GetMapping("/categories/{idc}")
    public String showCategory(@PathVariable("idc") Long id,Model m,@ModelAttribute("asoci")ProductosCategorias prodcate){

        Categoria cat = service.getcategoriaxId(id);
        m.addAttribute("categ", cat);
        m.addAttribute("prod", service.categoriaSinproducto(cat));

        return "showCategory.jsp";
         
    }
}
