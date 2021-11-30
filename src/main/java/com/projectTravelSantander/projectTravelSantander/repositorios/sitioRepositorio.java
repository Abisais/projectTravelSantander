/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectTravelSantander.projectTravelSantander.repositorios;

import com.projectTravelSantander.projectTravelSantander.modelos.sitioModelo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Enman
 */
public interface sitioRepositorio extends MongoRepository<sitioModelo, String>{
    
}
