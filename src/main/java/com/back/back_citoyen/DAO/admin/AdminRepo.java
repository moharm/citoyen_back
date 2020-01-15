package com.back.back_citoyen.DAO.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import com.back.back_citoyen.Entity.Admin.admin;

/**
 * AdminRepo
 */
@RepositoryRestResource
@CrossOrigin("*")
public interface AdminRepo extends JpaRepository<admin, Long> {

    public List<admin> findByEmail(String email);

}