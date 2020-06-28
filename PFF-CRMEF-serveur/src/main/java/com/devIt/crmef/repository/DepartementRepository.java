package com.devIt.crmef.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devIt.crmef.models.Departement;



@Repository
public interface DepartementRepository  extends JpaRepository<Departement, Long>{

}
