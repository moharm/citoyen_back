package com.back.back_citoyen.Controllers.association;

import java.io.IOException;

import com.back.back_citoyen.DAO.association.ActiviteRepo;
import com.back.back_citoyen.DAO.association.AssociationRepo;
import com.back.back_citoyen.Entity.Assosiation.assosiation;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.PushBuilder;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * associationController
 */
@RestController
public class associationController {

    @Autowired
    ActiviteRepo activiteRepo;
    @Autowired
    AssociationRepo associationRepo;

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

    @GetMapping(path = "/photoAssociation/{id}" , produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id")  Long id) throws IOException {
        String image = associationRepo.findById(id).get().getImage();
        return Files.readAllBytes(Paths.get("../Store/Association/"+image));
    }

}