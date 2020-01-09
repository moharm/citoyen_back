package com.back.back_citoyen.Entity.Citoyen;

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
    private Long age;
    @OneToMany(mappedBy = "citoyen")
    private Collection<Citoyen_parent> Citoyen_parents;

}