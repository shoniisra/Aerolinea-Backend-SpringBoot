package com.demo.aerolinea.models.services;

import com.demo.aerolinea.models.entities.Vuelo;

import java.util.List;

public interface IVueloService {
    public void save(Vuelo vuelo);

    public Vuelo findById(Integer id);

    public void delete(Integer id);

    public List<Vuelo> findAll();
}
