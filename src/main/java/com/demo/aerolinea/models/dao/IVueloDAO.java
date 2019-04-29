package com.demo.aerolinea.models.dao;

import com.demo.aerolinea.models.entities.Vuelo;
import org.springframework.data.repository.CrudRepository;

public interface IVueloDAO extends CrudRepository<Vuelo, Integer> {
}
