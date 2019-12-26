package com.back.back_citoyen.Entity.Assosiation;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Activite
 */
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Activite implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String titre;
    private  String desc;
    private  Date date_debut;
    private  Date date_fin;
    private  String localisation;
    private  Long effectif;
    private  Long effectif_now;
    private  String scoor;
    private  String statut;
    @ManyToOne
    private  assosiation assosiation;
    
}