/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectTravelSantander.projectTravelSantander.controladores;

import com.projectTravelSantander.projectTravelSantander.modelos.sitioModelo;
import com.projectTravelSantander.projectTravelSantander.repositorios.sitioRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Enman
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST})
@RequestMapping("/api/sitiosInteres")
public class sitioControlador {
    
     //Variable heredada del repositorio
    @Autowired
    private sitioRepositorio sitio;
    
    //Crear y Guardar nuevo sitioInteres
    @PostMapping("/guardar")
    public sitioModelo guardar( @RequestBody @Validated sitioModelo S){
        return sitio.insert(S);
    }
    
    // Consultar lista de sitiosInteres
    @GetMapping("/consultar")
    public List<sitioModelo> consultarSitiosInteres() {
        return sitio.findAll();
    }
    
    //Actualizar sitioInteres
    @PutMapping("/editar/{idSitio}")
    public sitioModelo actualizar(@PathVariable (value = "idSitio") String x, @RequestBody @Validated sitioModelo S) {
        return sitio.save(S);
    }
    
    //Eliminar sitioInteres
    @DeleteMapping("/eliminar/{idSitio}")
    public void eliminar(@PathVariable (value = "idSitio") String x) {
        sitio.deleteById(x);
    }
    
    //Consultar individual
    @GetMapping("/consultarIndividual/{idSitio}")
    public Optional<sitioModelo> consultarIndividual(@PathVariable (value = "idSitio") String x) {
        return sitio.findById(x);
    }
    
}
