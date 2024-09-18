package com.iesjuanbosco.ejemploweb.repository;

import com.iesjuanbosco.ejemploweb.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //Indica que esta clase es un repositorio, sirve para explotar la base de datos
public interface ProductoRepository extends JpaRepository<Producto,Long>{
}
