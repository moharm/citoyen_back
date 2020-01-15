package com.back.back_citoyen.Entity.Admin;

import org.springframework.stereotype.Component;

/**
 * LoginAdmin
 */
@Component
public class LoginAdminModel {

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