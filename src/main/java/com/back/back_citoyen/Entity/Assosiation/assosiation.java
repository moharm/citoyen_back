package com.back.back_citoyen.Entity.Assosiation;

import java.awt.Image;
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * assosiation
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assosiation")
@Entity
public class assosiation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String ville;
    private String Adresse1;
    private String Adresse2;
    private String localisation;
    private String Tel;
    private String email;
    private String image;
    private String domaine;
    private String mdp;
    @OneToMany(mappedBy = "assosiation")
    private Collection<Activite> activites;

    /**
     * @param nom
     * @param description
     * @param ville
     * @param adresse1
     * @param adresse2
     * @param localisation
     * @param tel
     * @param email
     * @param image
     * @param domaine
     * @param mdp
     */

    public assosiation(String nom, String description, String ville, String adresse1, String adresse2,
            String localisation, String tel, String email, String domaine, String mdp) {
        this.nom = nom;
        this.description = description;
        this.ville = ville;
        Adresse1 = adresse1;
        Adresse2 = adresse2;
        this.localisation = localisation;
        Tel = tel;
        this.email = email;
        this.domaine = domaine;
        this.mdp = mdp;
    }
}