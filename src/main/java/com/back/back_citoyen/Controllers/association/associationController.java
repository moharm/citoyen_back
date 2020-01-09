package com.back.back_citoyen.Controllers.association;

import com.back.back_citoyen.DAO.association.ActiviteRepo;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * associationController
 */
@RestController
public class associationController {

    @Autowired
    ActiviteRepo activiteRepo;

    JsonObject jsono;


    @PostMapping(value = "/association/offres" )
    public void getOffres(@RequestBody Long id ){

        System.out.println(id);
        // jsono=new JsonObject();
        activiteRepo.findByAssosiation_Id(id).forEach(a->{
            System.out.println(a.getTitre());
        });
       
        /*citoyenRepo.findAll().forEach(c->{
            System.out.println(c.getEmail());
        });
        System.out.println(citoyen.getEmail());*/

        //return jsono.toString();
    }

}