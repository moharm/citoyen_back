package com.back.back_citoyen.DAO.association;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import com.back.back_citoyen.Entity.Assosiation.assosiation;

/**
 * AssociationRepo
 */
@RepositoryRestResource
@CrossOrigin("*")
public interface AssociationRepo extends JpaRepository<assosiation, Long> {
    List<assosiation> findByEmail(String email);

}