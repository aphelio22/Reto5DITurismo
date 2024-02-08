package com.example.reto5diturismo.controller;

import com.example.reto5diturismo.model.Gastronomia;
import com.example.reto5diturismo.model.Museo;
import com.example.reto5diturismo.repository.MuseoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/turismo")
public class MuseoController {

    @Autowired
    private MuseoRepository museoRepository;

    @GetMapping("/museo")
    public List<Museo> getAllMuseos() {
        return museoRepository.findAll();
    }
}
