package com.back.back_citoyen.Controllers.association;


import com.back.back_citoyen.DAO.association.ActiviteRepo;
import com.back.back_citoyen.Entity.Assosiation.Activite;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PutMapping;
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


}