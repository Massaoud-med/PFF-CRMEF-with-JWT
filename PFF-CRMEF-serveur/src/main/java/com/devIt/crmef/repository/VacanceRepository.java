package com.devIt.crmef.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devIt.crmef.models.Vacance;



@Repository
public interface VacanceRepository extends JpaRepository<Vacance, Long>{
	
	

}
