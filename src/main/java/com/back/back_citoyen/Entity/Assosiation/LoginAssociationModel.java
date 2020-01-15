package com.back.back_citoyen.Entity.Assosiation;

import org.springframework.stereotype.Component;

/**
 * LoginCitoyen
 */
@Component
public class LoginAssociationModel {

    private String email;
    private String mdp;

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

}