package com.example.reto5diturismo.repository;

import com.example.reto5diturismo.model.Evento;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
    public Evento getEventoById(Integer id);
    public Evento getEventoByNombre(String nombre);
    public List<Evento> getEventoByPrecioBefore(Double precio);
    public List<Evento> getEventoByTematica(String tematica);
}
