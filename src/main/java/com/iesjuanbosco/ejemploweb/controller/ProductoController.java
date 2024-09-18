package com.iesjuanbosco.ejemploweb.controller;

import com.iesjuanbosco.ejemploweb.entity.Producto;
import com.iesjuanbosco.ejemploweb.repository.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller /*esta anotacion que indica a Spring que esta clase es un controlador,
se pone justo antes de la clase*/
public class ProductoController {
    //este metodo sirve para que cuando ponga " GET http://localhost/productos se ejecute este método

    private ProductoRepository productoRepository;

    public ProductoController(ProductoRepository repository){
        this.productoRepository = repository;
    }
    @GetMapping("/productos") /* aqúi la indicamos al spring que el siguiente metodo se va a
    ejecutar cuando el usuario acceda a la URL http://localhost/productos */
    public String  findAll(){
        List<Producto> productos = this.productoRepository.findAll();
        return "producto-list";
    }

    @GetMapping("/productos/add")
    public String add(){
        List<Producto> productos = new ArrayList<Producto>();
        Producto p1 = new Producto(null, "Producto 1",250,45.5);
        Producto p2 = new Producto(null, "Producto 2",10,25.5);
        Producto p3 = new Producto(null, "Producto 3",20,15.5);
        Producto p4 = new Producto(null, "Producto 4",30,65.5);
        productos.add((p1));
        productos.add((p2));
        productos.add((p3));
        productos.add((p4));

        //guardamos todos los producctos en la bbdd utilizando el objeto productoRepositpory
        this.productoRepository.saveAll(productos);

        return "redirect:/productos";

    }

}
