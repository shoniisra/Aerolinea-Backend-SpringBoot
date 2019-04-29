package com.demo.aerolinea.models.services;

import com.demo.aerolinea.models.dao.IAvionDAO;
import com.demo.aerolinea.models.entities.Avion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AvionService implements IAvionService {
    @Autowired
    private IAvionDAO dao;

    @Override
    public void save(Avion avion) {
        dao.save(avion);
    }

    @Override
    public Avion findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Avion> findAll() {
        return (List<Avion>) dao.findAll();
    }
}
