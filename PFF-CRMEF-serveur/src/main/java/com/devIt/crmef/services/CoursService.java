package com.devIt.crmef.services;

import java.util.List;

import com.devIt.crmef.models.Cours;


public interface CoursService {
	
	Cours createCours(Cours cours);

	Cours updateCours(Cours cours);

	List<Cours> getAllCours();

	Cours getCoursById(long idCours);

	void deleteCours(long idCours);
}
	


