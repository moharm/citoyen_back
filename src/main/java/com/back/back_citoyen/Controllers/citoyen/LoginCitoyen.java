package com.back.back_citoyen.Controllers.citoyen;

import java.util.List;

import com.back.back_citoyen.DAO.citoyen.CitoyenRepo;
import com.back.back_citoyen.Entity.Citoyen.Citoyen;
import com.back.back_citoyen.Entity.Citoyen.LoginCitoyenModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginCitoyen
 */
@RestController
public class LoginCitoyen {

  JsonObject jsono;
  @Autowired
  private CitoyenRepo citoyenRepo;

  @PostMapping(value = "/citoyen/login")
  public String Login(@RequestBody LoginCitoyenModel citoyen) {
    jsono = new JsonObject();
    Citoyen cit = null;
    if (!citoyenRepo.findByEmail(citoyen.getEmail()).isEmpty()) {
      cit = citoyenRepo.findByEmail(citoyen.getEmail()).get(0);
    }
    jsono.addProperty("success", false);
    if (cit != null) {
      if (citoyen.getMdp().equals(cit.getMdp())) {
        jsono.addProperty("success", true);
        jsono.addProperty("id", cit.getId());
        jsono.addProperty("nom", cit.getNom() + " " + cit.getPrenom());
      }
    }
    /*
     * citoyenRepo.findAll().forEach(c->{ System.out.println(c.getEmail()); });
     * System.out.println(citoyen.getEmail());
     */

    return jsono.toString();
  }



  @GetMapping(value = "/citoyen")
  public List<Citoyen> Liste() {
    List<Citoyen> liste = citoyenRepo.findAll();
    return liste;
  }

}