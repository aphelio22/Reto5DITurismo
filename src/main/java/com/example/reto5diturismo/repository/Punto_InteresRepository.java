package com.example.reto5diturismo.repository;

import com.example.reto5diturismo.model.Museo;
import com.example.reto5diturismo.model.Punto_Interes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Punto_InteresRepository extends JpaRepository<Punto_Interes, Integer> {
    public Punto_Interes getPunto_InteresById(Integer id);
    public Punto_Interes getPunto_InteresByNombre(String nombre);
}
