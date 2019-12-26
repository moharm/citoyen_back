package com.back.back_citoyen.DAO.citoyen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.back.back_citoyen.Entity.Citoyen.Citoyen;
/**
 * AdminRepo
 */
@RepositoryRestResource
@CrossOrigin("*")
public interface citoyenRepo extends JpaRepository<Citoyen, Long> {

    
}