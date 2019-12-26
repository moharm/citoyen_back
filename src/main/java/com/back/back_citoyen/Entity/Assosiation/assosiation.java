package com.back.back_citoyen.Entity.Assosiation;

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
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "assosiation")
@Entity
public class assosiation implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom;
    private  String desc;
    private  String ville;
    private  String Adresse1;
    private  String Adresse2;
    private  String localisation;
    private  String Tel;
    private  String Email;
    private  String image;
    private  String domaine;
    private  String mdp;
    private  String role;
    @OneToMany(mappedBy = "assosiation")
    private Collection<Activite> activites;
}