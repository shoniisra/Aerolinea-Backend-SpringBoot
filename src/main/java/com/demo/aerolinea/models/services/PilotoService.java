package com.demo.aerolinea.models.services;

import com.demo.aerolinea.models.dao.IPilotoDAO;
import com.demo.aerolinea.models.entities.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PilotoService implements IPilotoService {
    @Autowired
    private IPilotoDAO dao;

    @Override
    public void save(Piloto piloto) {
        dao.save(piloto);
    }

    @Override
    public Piloto findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Piloto> findAll() {
        return (List<Piloto>) dao.findAll();
    }
}
