package com.back.back_citoyen.Entity.Citoyen;

import org.springframework.stereotype.Component;

/**
 * LoginCitoyen
 */
@Component
public class LoginCitoyenModel {

    private String email;
    private String pwd;

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

    /**
     * @return String return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}