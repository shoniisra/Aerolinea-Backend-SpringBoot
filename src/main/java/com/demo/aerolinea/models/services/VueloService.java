package com.demo.aerolinea.models.services;
import java.util.List;

import com.demo.aerolinea.models.dao.IVueloDAO;
import com.demo.aerolinea.models.entities.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueloService implements IVueloService{

    @Autowired
    private IVueloDAO dao;

    @Override
    public void save(Vuelo vuelo) {
        dao.save(vuelo);
    }

    @Override
    public Vuelo findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Vuelo> findAll() {
        return (List<Vuelo>) dao.findAll();
    }
}
