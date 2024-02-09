package com.example.reto5diturismo.repository;

import com.example.reto5diturismo.model.Evento;
import com.example.reto5diturismo.model.Gastronomia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastronomiaRepository extends JpaRepository<Gastronomia, Integer> {
    public Gastronomia getGastronomiaById(Integer id);
    public Gastronomia getGastronomiaByOrigen(String origen);
    public Gastronomia getGastronomiaByNombre(String nombre);
}
