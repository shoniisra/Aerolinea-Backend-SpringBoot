package com.demo.aerolinea.controllers;

import com.demo.aerolinea.models.dao.IPilotoDAO;
import com.demo.aerolinea.models.entities.Piloto;
import com.demo.aerolinea.models.services.IPilotoService;
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
@RequestMapping(value="/piloto")
public class PilotoController {
    //servicio => Inyeccion de dependencias

    @Autowired
    //private IPilotoDAO service;
    private IPilotoService service;

    @GetMapping(value="/create" )
    public String create(Model model){
        Piloto piloto=new Piloto();
        model.addAttribute("piloto",piloto);
        return "piloto/form";
    }
    @PostMapping(value="/save" )
    public String save(Piloto piloto,Model model){
        //si hago con dao realizo un if con el id==null
        try{
            service.save(piloto);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/piloto/list";
    }
    @GetMapping(value="/retrieve/{id}" )
    public String retrieve(@PathVariable(value = "id") Integer id,
                           Model model){
        Piloto piloto=service.findById(id);
        model.addAttribute("piloto",piloto);
        return "piloto/card";
    }
    @GetMapping(value="/update/{id}" )
    public String update(@PathVariable(value = "id") Integer id,
                         Model model){
        Piloto piloto=service.findById(id);
        model.addAttribute("piloto",piloto);
        return "piloto/form";
    }
    @GetMapping(value="/delete" )
    public String delete(@PathVariable(value = "id") Integer id,
                         Model model){
        try{
            service.delete(id);
        }catch (Exception ex){
            model.addAttribute("error: ",ex.toString());
        }

        return "redirect:/piloto/List";
    }

    @GetMapping(value="/list" )
    public String list(Model model){
        List<Piloto> pilotos=service.findAll();
        model.addAttribute("lista",pilotos);
        return "piloto/list";
    }
}
