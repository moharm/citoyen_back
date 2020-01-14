package com.back.back_citoyen.Entity.Citoyen;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.back.back_citoyen.Entity.Assosiation.Activite;
import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Citoyen
 */
@Table(name = "citoyen")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citoyen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String mdp;
    private String ville;
    private String Adresse1;
    private String Adresse2;
    private String Tel;
    private String email;
    private String image;
    private Long Score;
    private String DateNaissance;
    @Expose(serialize = false)
    @OneToMany(mappedBy = "citoyen")
    private Collection<Citoyen_parent> Citoyen_parents;
    @ManyToMany
    private Collection<Activite> cit_Activites;

    /**
     * @param nom
     * @param prenom
     * @param mdp
     * @param ville
     * @param adresse1
     * @param tel
     * @param email
     * @param image
     * @param dateNaissance
     */

    public Citoyen(String nom, String prenom, String mdp, String ville, String adresse1, String tel, String email, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.ville = ville;
        Adresse1 = adresse1;
        Tel = tel;
        this.email = email;
        DateNaissance = dateNaissance;
    }



    
}