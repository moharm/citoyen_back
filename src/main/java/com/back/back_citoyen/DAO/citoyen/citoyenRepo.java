package com.back.back_citoyen.DAO.citoyen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.back.back_citoyen.Entity.Citoyen.Citoyen;
/**
 * AdminRepo
 */
@RepositoryRestResource
@CrossOrigin("*")
public interface CitoyenRepo extends JpaRepository<Citoyen, Long> {

    
}