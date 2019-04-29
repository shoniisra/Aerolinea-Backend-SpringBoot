package com.demo.aerolinea.models.dao;

import com.demo.aerolinea.models.entities.Avion;
import org.springframework.data.repository.CrudRepository;

public interface IAvionDAO extends CrudRepository<Avion, Integer> {

}
