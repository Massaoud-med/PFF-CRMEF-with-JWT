package com.devIt.crmef.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devIt.crmef.models.Filiere;



@Repository

public interface FilierRepository  extends JpaRepository<Filiere, Long>{

}
