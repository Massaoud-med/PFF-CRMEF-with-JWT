package com.devIt.crmef.services;

import java.util.List;

import com.devIt.crmef.models.Formateur;



public interface formateurService {
	
	Formateur createFormateur(Formateur formateur);

	Formateur updateFormateur(Formateur formateur);

	List<Formateur> getAllFormateur();

	Formateur getFormateurById(long idFormateur);

	void deleteFormateur(long idFormateur);

}
