package com.back.back_citoyen.Entity.Admin;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Recompence
 */
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Recompence implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String titre;
    private  String description;
    private  Date Date;
    private  Long Nombre;
    private  Long score;

    /**
     * @param titre
     * @param description
     * @param date
     * @param nombre
     * @param score
     */

    public Recompence(String titre, String description, java.util.Date date, Long nombre, Long score) {
        this.titre = titre;
        this.description = description;
        Date = date;
        Nombre = nombre;
        this.score = score;
    }
    
}