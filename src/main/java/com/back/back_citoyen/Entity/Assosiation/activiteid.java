package com.back.back_citoyen.Entity.Assosiation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 * activiteid
 */
@Projection(name = "T", types = Activite.class)
public interface activiteid {
    public Long getId();

    public String getTitre();

    public String getScor();
}