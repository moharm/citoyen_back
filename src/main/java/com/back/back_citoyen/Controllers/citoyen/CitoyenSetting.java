package com.back.back_citoyen.Controllers.citoyen;

import java.io.IOException;

import com.back.back_citoyen.DAO.association.ActiviteRepo;
import com.back.back_citoyen.DAO.association.AssociationRepo;
import com.back.back_citoyen.DAO.citoyen.CitoyenRepo;
import com.back.back_citoyen.Entity.Assosiation.Activite;
import com.back.back_citoyen.Entity.Assosiation.assosiation;
import com.back.back_citoyen.Entity.Citoyen.Citoyen;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * CitoyenSetting
 */
@RestController
public class CitoyenSetting {

    @Autowired
    CitoyenRepo citoyenRepo;
    @Autowired
    ActiviteRepo activiteRepo;

    @GetMapping(path = "/photoCitoyen/{id}" , produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id")  Long id) throws IOException {
        String image = citoyenRepo.findById(id).get().getImage();
        return Files.readAllBytes(Paths.get("../Store/Citoyen/"+image));
    }

    @PutMapping(path = "/citoyen/Participer")
    public String Participer(@RequestParam(value = "id_citoyen") Long  id_citoyen,
                                @RequestParam(value = "id_Activite") Long id_Activite){
            


            Citoyen citoyen = citoyenRepo.getOne(id_citoyen);
            Activite activite = activiteRepo.getOne(id_Activite);

            
            if(citoyen.getCit_Activites().add(activite)){
                if(activite.getPar_Citoyens().add(citoyen)){
                    citoyenRepo.save(citoyen);
                    return "success";
                }
            }
            return "Failed";

    }
    
}