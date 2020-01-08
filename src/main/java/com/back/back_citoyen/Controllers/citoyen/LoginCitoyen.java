package com.back.back_citoyen.Controllers.citoyen;

import com.back.back_citoyen.DAO.citoyen.CitoyenRepo;
import com.back.back_citoyen.Entity.Citoyen.LoginCitoyenModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginCitoyen
 */
@RestController
public class LoginCitoyen {

    @Autowired
    private CitoyenRepo citoyenRepo;

    @PostMapping(value = "/citoyen/login" )
    public String Login(@RequestBody LoginCitoyenModel citoyen ){
        citoyenRepo.findAll().forEach(c->{
            System.out.println(c.getEmail( ));
        });
        System.out.println(citoyen.getEmail());

        return "yesss";
    }
    

    
}