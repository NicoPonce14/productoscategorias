package com.nicolas.productosycategorias.productosycategorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nicolas.productosycategorias.productosycategorias.services.MainService;

@Controller
public class MainController {
    @Autowired
    private MainService serv;
    
    @GetMapping("/")
    private String raiz(Model m){
        m.addAttribute("productos", serv.todosProd());
        m.addAttribute("categorias", serv.todosCateg());
        return "index.jsp";
    }
}
