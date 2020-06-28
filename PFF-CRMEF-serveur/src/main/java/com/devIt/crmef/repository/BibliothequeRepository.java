package com.devIt.crmef.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devIt.crmef.models.Bibliotheque;



@Repository
public interface BibliothequeRepository  extends JpaRepository<Bibliotheque, Long>{

}
