package com.back.back_citoyen.Entity.Citoyen;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Citoyen_parent
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Citoyen_parent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String ville;
    private String Adresse1;
    private String Adresse2;
    private String Tel;
    private String Email;
    private String image;
    @ManyToOne

    private Citoyen citoyen;
}