/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectTravelSantander.projectTravelSantander.controladores;

import com.projectTravelSantander.projectTravelSantander.modelos.comentarioModelo;
import com.projectTravelSantander.projectTravelSantander.repositorios.comentarioRepositorio;
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
@RequestMapping("/api/comentarios")
public class comentarioControlador {
    
    //Variable heredada del repositorio
    @Autowired
    private comentarioRepositorio comentario;
    
    //Crear y Guardar nuevo comentario
    @PostMapping("/guardar")
    public comentarioModelo guardar( @RequestBody @Validated comentarioModelo C){
        return comentario.insert(C);
    }
    
    // Consultar lista de comentarios
    @GetMapping("/consultar")
    public List<comentarioModelo> consultarSitiosInteres() {
        return comentario.findAll();
    }
    
    //Actualizar comentario
    @PutMapping("/editar/{idComentario}")
    public comentarioModelo actualizar(@PathVariable (value = "idComentario") String x, @RequestBody @Validated comentarioModelo C) {
        return comentario.save(C);
    }
    
    //Eliminar comentario
    @DeleteMapping("/eliminar/{idComentario}")
    public void eliminar(@PathVariable (value = "idComentario") String x) {
        comentario.deleteById(x);
    }
    
    //Consultar comentario
    @GetMapping("/consultarIndividual/{idComentario}")
    public Optional<comentarioModelo> consultarIndividual(@PathVariable (value = "idComentario") String x) {
        return comentario.findById(x);
    }
}
