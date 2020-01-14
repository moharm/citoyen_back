package com.back.back_citoyen.Controllers.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.back.back_citoyen.DAO.admin.RecompenceRepo;
import com.back.back_citoyen.Entity.Admin.Recompence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RecompenceController
 */
@RestController
public class RecompenceController {

    @Autowired
    RecompenceRepo recompenceRepo;

    @CrossOrigin("*")
    @PostMapping(value = "/admin/AddRecompence")
    public String AddRecompence(@RequestBody Recompence recompence) {
        recompenceRepo.save(recompence);
        if (recompenceRepo.save(recompence) != null) {
            return "succed";
        } else {
            return "failed";
        }
    }
    /*
     * @PostMapping(value = "/admin/AddRecompence") public String
     * AddRecompence(@RequestParam("titre") String
     * titre, @RequestParam("description") String description,
     * 
     * @RequestParam("date") String date, @RequestParam("nombre") Long
     * nombre, @RequestParam("score") Long score) throws ParseException {
     * 
     * Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS").parse(date);
     * 
     * if(recompenceRepo.save(new Recompence(titre, description, d, nombre,
     * score))!=null){ return "success"; } return "failed"; }
     */

}