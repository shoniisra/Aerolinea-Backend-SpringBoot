package com.demo.aerolinea.models.services;

import com.demo.aerolinea.models.entities.Avion;

import java.util.List;

public interface IAvionService {
    public void save(Avion avion);

    public Avion findById(Integer id);

    public void delete(Integer id);

    public List<Avion> findAll();
}