package com.back.back_citoyen.Controllers.association;

import java.util.List;
import java.util.Optional;

import com.back.back_citoyen.DAO.association.ActiviteRepo;
import com.back.back_citoyen.Entity.Assosiation.Activite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * activiteController
 */
@RestController
public class activiteController {

    @Autowired
    ActiviteRepo activiteRepo;

    Activite activite = new Activite();

    @CrossOrigin("*")
    @PutMapping(value = "/ActionOnActivite")
    public String ActionOnActivite(@RequestParam("id") Long id, @RequestParam("status") String status,
            @RequestParam("score") String score) {

        if (status.equals("accepted")) {
            activite = activiteRepo.getOne(id);
            activite.setStatut(status);
            activite.setScor(score);
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

    @CrossOrigin("*")
    @GetMapping(value = "/activites/inProgress")
    public List<Activite> ListeInProgress() {
        List<Activite> liste = activiteRepo.findByStatut("in progress");

        return liste;
    }
}