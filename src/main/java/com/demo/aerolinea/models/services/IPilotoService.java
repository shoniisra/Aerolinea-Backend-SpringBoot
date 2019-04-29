package com.demo.aerolinea.models.services;

import com.demo.aerolinea.models.entities.Piloto;

import java.util.List;

public interface IPilotoService {
    public void save(Piloto piloto);

    public Piloto findById(Integer id);

    public void delete(Integer id);

    public List<Piloto> findAll();
}