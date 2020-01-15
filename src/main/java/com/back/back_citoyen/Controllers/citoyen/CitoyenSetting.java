package com.back.back_citoyen.Controllers.citoyen;

import java.io.IOException;

import com.back.back_citoyen.DAO.association.ActiviteRepo;
import com.back.back_citoyen.DAO.association.AssociationRepo;
import com.back.back_citoyen.DAO.citoyen.CitoyenRepo;
import com.back.back_citoyen.Entity.Assosiation.Activite;
import com.back.back_citoyen.Entity.Assosiation.assosiation;
import com.back.back_citoyen.Entity.Citoyen.Citoyen;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;
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

import antlr.collections.List;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Collection;

/**
 * CitoyenSetting
 */
@RestController
public class CitoyenSetting {

    JsonArray jsono;
    @Autowired
    CitoyenRepo citoyenRepo;
    @Autowired
    ActiviteRepo activiteRepo;

    JSONObject o;

    @GetMapping(path = "/photoCitoyen/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) {
        try {
            String image = citoyenRepo.findById(id).get().getImage();
            return Files.readAllBytes(Paths.get("../Store/Citoyen/" + image));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping(path = "/citoyen/Participer")
    public String Participer(@RequestBody(required = false) String id_citoyen) throws JSONException {
        o = new JSONObject(id_citoyen);
        Citoyen citoyen = citoyenRepo.getOne(Long.parseLong(o.getString("id_citoyen")));
        Activite activite = activiteRepo.getOne(Long.parseLong(o.getString("id_Activite")));
        try {
            if (citoyen.getCit_Activites().add(activite)) {
                if (activite.getPar_Citoyens().add(citoyen)) {
                    if (citoyenRepo.save(citoyen) != null) {
                        System.out.println("success");
                        return "success";
                    }
                }
            }
            return "Failed";
        } catch (Exception e) {
            // TODO: handle exception
            return "Failed";

        }

    }

    @PostMapping(value = "/citoyen/getpart")
    public Collection<Activite> getcitat(@RequestBody String data) throws JSONException {

        o = new JSONObject(data);
        Long id = o.getLong("id");
        System.out.println("********************");
        Collection<Activite> c = citoyenRepo.getOne(id).getCit_Activites();
        /*
         * 
         */
        return c;

    }
    
    @PostMapping(value = "/citoyen/AddScore")
    public String Participe_comfirme(@RequestParam("id_Citoyen") Long id_Citoyen, @RequestParam("id_Activite") Long id_Activite) throws  SQLException {
        try {
            // System.out.println(id_Activite);
            Long oo = (long) 6;
            Long ScoreActivite = Long.parseLong(activiteRepo.getOne(id_Activite).getScor());
            System.out.println(activiteRepo.getOne(id_Activite).getScor());
            Citoyen citoyen = citoyenRepo.getOne(id_Citoyen);
            System.out.println(ScoreActivite);
            citoyen.AddScore(ScoreActivite);
            System.out.println(citoyen.toString());
            citoyenRepo.save(citoyen);
            System.out.println(ScoreActivite);
            return "success";
        } catch (Exception e) {
            System.out.println("error");
            return e.getMessage();

        }
   
    }


}