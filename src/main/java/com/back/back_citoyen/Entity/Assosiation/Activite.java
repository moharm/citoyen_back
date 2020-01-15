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
    @JsonIgnore
    @ManyToOne
    private assosiation assosiation;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
            CascadeType.MERGE }, mappedBy = "cit_Activites")
    @JsonIgnore
    private Collection<Citoyen> par_Citoyens;

}