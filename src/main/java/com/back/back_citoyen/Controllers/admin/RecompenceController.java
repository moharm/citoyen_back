package com.back.back_citoyen.Controllers.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.back.back_citoyen.DAO.admin.RecompenceRepo;
import com.back.back_citoyen.Entity.Admin.Recompence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @CrossOrigin("*")
    @GetMapping(value = "/admin/recompences")
    public List<Recompence> ListeRecompense() {
        List<Recompence> liste = recompenceRepo.findAll();

        return liste;
    }

}