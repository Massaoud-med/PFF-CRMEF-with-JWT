package com.devIt.crmef.services;

import java.util.List;

import com.devIt.crmef.models.Stagiaire;



public interface stagiairesService {
	
	Stagiaire createStagiaire(Stagiaire stagiaire);

	Stagiaire updateStagiaire(Stagiaire stagiaire);

	List<Stagiaire> getAllStagiaire();

	Stagiaire getStagiaireById(long stgId);

	void deleteStagiaire(long stgcId);

}
