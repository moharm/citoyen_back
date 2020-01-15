package com.back.back_citoyen.Controllers.association;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.back.back_citoyen.DAO.association.ActiviteRepo;
import com.back.back_citoyen.DAO.association.AssociationRepo;
import com.back.back_citoyen.Entity.Assosiation.Activite;
import com.back.back_citoyen.Entity.Assosiation.assosiation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * activiteController
 */
@RestController
public class activiteController {

    @Autowired
    ActiviteRepo activiteRepo;
    @Autowired
    AssociationRepo associationRepo;

    Activite activite = new Activite();

    @CrossOrigin("*")
    @PutMapping(value = "/ActionOnActivite")
    public String ActionOnActivite(@RequestParam("id") Long id, @RequestParam("status") String status,
            @RequestParam("score") String score) {

        if (status.equals("accepted")) {
            activite = activiteRepo.getOne(id);
            activite.setStatut(status);
            activite.setScore(score);
            activiteRepo.save(activite);
            return "accepted";
        } else if (status.equals("refused")) {
            activite = activiteRepo.getOne(id);
            activite.setStatut(status);
            activiteRepo.save(activite);
            return "refused";
        } else {
            return "failed";
        }

    }

    @PostMapping(value = "/AjouterActivite")
    public String AjouterActivite(@RequestParam(value = "image", required = false) MultipartFile image,
    @RequestParam("titre") String titre, @RequestParam("description") String description,
    @RequestParam("date_debut") Date date_debut, @RequestParam("date_fin") Date date_fin,
    @RequestParam("longitude") Double longitude, @RequestParam("latitude") Double latitude,
    @RequestParam("effectif") Long effectif, @RequestParam("scor") String scor,
    @RequestParam("assosiation_id") Long assosiation_id) {

        try {
            assosiation asso = associationRepo.getOne(assosiation_id);
            activiteRepo.save(new Activite(titre, description, date_debut, date_fin, longitude, latitude, effectif, scor, image.getOriginalFilename(), asso,"in progress"));


            return "success";
        } catch (Exception e) {
            //TODO: handle exception
            return "Failed";
        }
    }
    @CrossOrigin("*")
    @GetMapping(value = "/activites/inProgress")
    public List<Activite> ListeInProgress() {
        List<Activite> liste = activiteRepo.findByStatut("in progress");

        return liste;
    }
}