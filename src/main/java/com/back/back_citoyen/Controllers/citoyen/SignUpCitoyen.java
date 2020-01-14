package com.back.back_citoyen.Controllers.citoyen;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.back.back_citoyen.DAO.association.AssociationRepo;
import com.back.back_citoyen.DAO.citoyen.CitoyenRepo;
import com.back.back_citoyen.Entity.Assosiation.assosiation;
import com.back.back_citoyen.Entity.Citoyen.Citoyen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 * SignUpCitoye
 */
@CrossOrigin("*")
@RestController
public class SignUpCitoyen {

    @Autowired
    CitoyenRepo citoyenRepo;

    @PostMapping(value = "/citoyen/signup")
    public String Signup(@RequestParam(value = "image", required = false) MultipartFile image,
                            @RequestParam("prenom") String prenom,
                            @RequestParam("nom") String nom,
                            @RequestParam("mdp") String mdp,
                            @RequestParam("ville") String ville,
                            @RequestParam("adresse1") String adresse1,
                            @RequestParam("tel") String tel,
                            @RequestParam("email") String email,
                            @RequestParam("dateNaissance") String dateNaissance) throws IOException {
                                
            System.out.println(image.getContentType().split("/")[1]);
            // Long id =associationRepo.count()+1;
            Citoyen citoyen = new Citoyen(nom, prenom, mdp, ville, adresse1, tel, email, dateNaissance);
            Long id = citoyenRepo.save(citoyen).getId();
            citoyen.setId(id);
            citoyen.setImage(id + "." + image.getContentType().split("/")[1]);
            citoyenRepo.save(citoyen);
            Files.write(Paths.get("../Store/Citoyen/" + citoyen.getImage()), image.getBytes());
            if (citoyenRepo.save(citoyen) != null) {
                return "seccess";
            }
            return "failed";
       
    }

}