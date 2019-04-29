package com.demo.aerolinea.models.dao;

import com.demo.aerolinea.models.entities.Piloto;
import org.springframework.data.repository.CrudRepository;

public interface IPilotoDAO extends CrudRepository<Piloto, Integer> {
}
