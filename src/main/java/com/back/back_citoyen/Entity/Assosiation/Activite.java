package com.back.back_citoyen.Entity.Assosiation;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.back.back_citoyen.Entity.Citoyen.Citoyen;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Activite
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Activite")
@Entity
public class Activite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Date date_debut;
    private Date date_fin;
    private Double longitude;
    private Double latitude;
    private Long effectif;
    private Long effectif_now;
    private String scor;
    private String statut;
    private String image;
    @JsonIgnore
    @ManyToOne
    private assosiation assosiation;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
            CascadeType.MERGE }, mappedBy = "cit_Activites")
    @JsonIgnore
    private Collection<Citoyen> par_Citoyens;

    /**
     * @param titre
     * @param description
     * @param date_debut2
     * @param date_fin2
     * @param longitude
     * @param latitude
     * @param effectif
     * @param score
     * @param image
     * @param assosiation
     */

    public Activite(String titre, String description, java.sql.Date date_debut2, java.sql.Date date_fin2, Double longitude, Double latitude,
            Long effectif, String scor, String image,
            com.back.back_citoyen.Entity.Assosiation.assosiation assosiation,String statut) {
        this.titre = titre;
        this.description = description;
        this.date_debut = date_debut2;
        this.date_fin = date_fin2;
        this.longitude = longitude;
        this.latitude = latitude;
        this.effectif = effectif;
        this.scor = scor;
        this.image = image;
        this.assosiation = assosiation;
        this.statut = statut;
    }

    

}