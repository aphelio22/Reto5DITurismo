package com.example.reto5diturismo.repository;

import com.example.reto5diturismo.model.Museo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MuseoRepository extends JpaRepository<Museo, Integer> {
    public Museo getMuseoById(Integer id);
    public Museo getMuseoByNombre(String nombre);
    public List<Museo> getMuseoByPrecioBefore(Double precio);
    public List<Museo> getMuseoByTematica(String tematica);
    public List<Museo> getMuseoByDescuento(String descuento);
}
