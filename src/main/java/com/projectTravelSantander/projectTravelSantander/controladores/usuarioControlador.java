/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectTravelSantander.projectTravelSantander.controladores;

import com.projectTravelSantander.projectTravelSantander.modelos.usuarioModelo;
import com.projectTravelSantander.projectTravelSantander.repositorios.usuarioRepositorio;
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
@RequestMapping("/api/usuarios")
public class usuarioControlador {
    
    //Variable heredada del repositorio
    @Autowired
    private usuarioRepositorio user;
    
    //Crear y Guardar nuevo usuario
    @PostMapping("/guardar")
    public usuarioModelo guardar( @RequestBody @Validated usuarioModelo U){
        return user.insert(U);
    }
    
    // Consultar lista de usuarios
    @GetMapping("/consultar")
    public List<usuarioModelo> consultarUsuarios() {
        return user.findAll();
    }
    
    //Actualizar usuario
    @PutMapping("/editar/{idUser}")
    public usuarioModelo actualizar(@PathVariable (value = "idUser") String x, @RequestBody @Validated usuarioModelo U) {
        return user.save(U);
    }
    
    //Eliminar usuario
    @DeleteMapping("/eliminar/{idUser}")
    public void eliminar(@PathVariable (value = "idUser") String x) {
        user.deleteById(x);
    }
    
    //Consultar individual
    @GetMapping("/consultarIndividual/{idUser}")
    public Optional<usuarioModelo> consultarIndividual(@PathVariable (value = "idSitio") String x) {
        return user.findById(x);
    }
}
