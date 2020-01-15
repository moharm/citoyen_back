package com.back.back_citoyen.Controllers.admin;

import java.util.List;

import com.back.back_citoyen.DAO.admin.AdminRepo;
import com.back.back_citoyen.DAO.citoyen.CitoyenRepo;
import com.back.back_citoyen.Entity.Citoyen.Citoyen;
import com.back.back_citoyen.Entity.Admin.LoginAdminModel;
import com.back.back_citoyen.Entity.Admin.admin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginAdmin
 */
@RestController
public class LoginAdmin {

  JsonObject jsono;

  @Autowired
  public AdminRepo adminRepo;

  @CrossOrigin("*")
  @PostMapping(value = "/admin/login")
  public String Login(@RequestBody LoginAdminModel admin) {
    jsono = new JsonObject();
    admin adm = null;
    if (!adminRepo.findByEmail(admin.getEmail()).isEmpty()) {
      adm = adminRepo.findByEmail(admin.getEmail()).get(0);
    }
    jsono.addProperty("success", false);
    if (adm != null) {
      if (admin.getMdp().equals(adm.getMdp())) {
        jsono.addProperty("success", true);
        jsono.addProperty("id", adm.getId());
        jsono.addProperty("nom", adm.getNom() + " " + adm.getPrenom());
      }
    }
    return jsono.toString();
  }

  /*
   * @GetMapping(value = "/citoyen") public List<Citoyen> Liste() { List<Citoyen>
   * liste = citoyenRepo.findAll(); return liste; }
   */

}