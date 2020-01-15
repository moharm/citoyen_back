package com.back.back_citoyen.Entity.Admin;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * admin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String ville;
    private String adresse1;
    private String adresse2;
    private String tel;
    private String email;
    private String image;
    private String mdp;
    private String role;

}