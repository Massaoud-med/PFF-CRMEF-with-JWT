package com.devIt.crmef.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devIt.crmef.models.Stagiaire;




@Repository
public interface StagiaireRepository  extends JpaRepository<Stagiaire, Long>{
	
	/*@Query("select s from Stagiaire s where s.filier= :x")
	public List<Stagiaire> cherche(@Param("x") String code_filier);*/

	


}
