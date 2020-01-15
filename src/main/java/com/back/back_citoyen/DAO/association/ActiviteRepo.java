package com.back.back_citoyen.DAO.association;

import java.util.List;

import com.back.back_citoyen.Entity.Assosiation.Activite;
import com.back.back_citoyen.Entity.Assosiation.activiteid;
import com.back.back_citoyen.Entity.Assosiation.assosiation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * ActiviteRepo
 */
@RepositoryRestResource
@CrossOrigin("*")
public interface ActiviteRepo extends JpaRepository<Activite, Long> {

    public List<Activite> findByAssosiation_Id(Long id);

    @RestResource(path = "/ByStatus")
    public List<Activite> findByStatut(@Param("status") String statut);

    public List<Activite> findByAssosiation(assosiation assosiation);

}