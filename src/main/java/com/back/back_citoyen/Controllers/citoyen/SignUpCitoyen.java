package com.back.back_citoyen.Controllers.citoyen;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.back.back_citoyen.DAO.association.AssociationRepo;
import com.back.back_citoyen.Entity.Assosiation.assosiation;

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
@RestController
public class SignUpCitoyen {

    // @CrossOrigin("*")
    // @PostMapping(value = "/citoyen/signup")
    // public String Signup(@RequestParam(value = "image", required = false) MultipartFile image,
    //                         @RequestParam("prenom") String prenom,
    //                         @RequestParam("nom") String nom,
    //                         @RequestParam("mdp") String mdp,
    //                         @RequestParam("ville") String ville,
    //                         @RequestParam("Adresse1") String Adresse1,
    //                         @RequestParam("Adresse2") String Adresse2,
    //                         @RequestParam("Tel") String Tel,
    //                         @RequestParam("email") String email,
    //                         @RequestParam("email") String image,
    //                         @RequestParam("email") Long age) throws IOException {
                                

    //     System.out.println(image.getContentType().split("/")[1]);
     
    //     Files.write(Paths.get("../Store/Citoyen/" + image.getOriginalFilename()), image.getBytes());
    //     return "prenom";
    // }

}