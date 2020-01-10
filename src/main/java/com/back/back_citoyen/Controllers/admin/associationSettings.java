package com.back.back_citoyen.Controllers.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.back.back_citoyen.DAO.association.AssociationRepo;
import com.back.back_citoyen.Entity.Assosiation.assosiation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * associationSettings
 */
@RestController
public class associationSettings {

    @Autowired
    AssociationRepo associationRepo;

    @PostMapping(value = "/admin/AddAssociation")
    public String AddAssociation(@RequestParam(value = "image", required = false) MultipartFile image,
            @RequestParam("adresse1") String adresse1, @RequestParam("adresse2") String adresse2,
            @RequestParam("email") String email, @RequestParam("tel") String tel,
            @RequestParam("description") String description, @RequestParam("domaine") String domaine,
            @RequestParam("localisation") String localisation, @RequestParam("mdp") String mdp,
            @RequestParam("nom") String nom, @RequestParam("ville") String ville) throws IOException {

                System.out.println(image.getContentType().split("/")[1]);
        // Long id =associationRepo.count()+1;
        assosiation asso = new assosiation(nom,description,ville,adresse1,adresse2,localisation,tel,email,domaine,mdp);
        Long id = associationRepo.save(asso).getId();
        asso.setId(id);
        asso.setImage(id+"."+image.getContentType().split("/")[1]);
        associationRepo.save(asso);
        Files.write(Paths.get("../Store/Association/"+ asso.getImage()),image.getBytes());
        if(associationRepo.save(asso)!=null){
            return "seccess";
        }
        return "failed";


    }

    
}