package com.demo.aerolinea.controllers;

import com.demo.aerolinea.models.dao.IAvionDAO;
import com.demo.aerolinea.models.entities.Avion;
import com.demo.aerolinea.models.services.IAvionService;
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
@RequestMapping(value="/avion")
public class AvionController {
    //servicio => Inyeccion de dependencias

    @Autowired
    //private IAvionDAO service;
    private IAvionService service;

    @GetMapping(value="/create" )
    public String create(Model model){
        Avion avion=new Avion();
        model.addAttribute("avion",avion);
        return "avion/form";
    }
    @PostMapping(value="/save" )
    public String save(Avion avion,Model model){
        //si hago con dao realizo un if con el id==null
        try{
            service.save(avion);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/avion/list";
    }
    @GetMapping(value="/retrieve/{id}" )
    public String retrieve(@PathVariable(value = "id") Integer id,
                           Model model){
        Avion avion=service.findById(id);
        model.addAttribute("avion",avion);
        return "avion/card";
    }
    @GetMapping(value="/update/{id}" )
    public String update(@PathVariable(value = "id") Integer id,
                         Model model){
        Avion avion=service.findById(id);
        model.addAttribute("avion",avion);
        return "avion/form";
    }
    @GetMapping(value="/delete" )
    public String delete(@PathVariable(value = "id") Integer id,
                         Model model){
        try{
            service.delete(id);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/avion/List";
    }

    @GetMapping(value="/list" )
    public String list(Model model){
        List<Avion> avions=service.findAll();
        model.addAttribute("lista",avions);
        return "avion/list";
    }
}
