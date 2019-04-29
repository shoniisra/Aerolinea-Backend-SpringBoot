package com.demo.aerolinea.controllers;


import com.demo.aerolinea.models.dao.IVueloDAO;
import com.demo.aerolinea.models.entities.Vuelo;
import com.demo.aerolinea.models.services.IVueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping(value="/vuelo")
public class VueloController {
    //servicio => Inyeccion de dependencias

    @Autowired
    //private IVueloDAO service;
    private IVueloService service;

    @GetMapping(value="/create" )
    public String create(Model model){
        Vuelo vuelo=new Vuelo();
        model.addAttribute("vuelo",vuelo);
        return "vuelo/form";
    }
    @PostMapping(value="/save" )
    public String save(Vuelo vuelo,Model model){
        //si hago con dao realizo un if con el id==null
        try{
            service.save(vuelo);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/vuelo/list";
    }
    @GetMapping(value="/retrieve/{id}" )
    public String retrieve(@PathVariable(value = "id") Integer id,
                           Model model){
        Vuelo vuelo=service.findById(id);
        model.addAttribute("vuelo",vuelo);
        return "vuelo/card";
    }
    @GetMapping(value="/update/{id}" )
    public String update(@PathVariable(value = "id") Integer id,
                         Model model){
        Vuelo vuelo=service.findById(id);
        model.addAttribute("vuelo",vuelo);
        return "vuelo/form";
    }
    @GetMapping(value="/delete" )
    public String delete(@PathVariable(value = "id") Integer id,
                         Model model){
        try{
            service.delete(id);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/vuelo/List";
    }

    @GetMapping(value="/list" )
    public String list(Model model){
        List<Vuelo> vuelos=service.findAll();
        model.addAttribute("lista",vuelos);
        return "vuelo/list";
    }
}

