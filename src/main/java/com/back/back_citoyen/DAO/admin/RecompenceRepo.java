package com.back.back_citoyen.DAO.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.back.back_citoyen.Entity.Admin.Recompence;

/**
 * RecompenceRepo
 */
@RepositoryRestResource
@CrossOrigin("*")
public interface RecompenceRepo extends JpaRepository<Recompence, Long>{

    
}