package com.devIt.crmef.services;

import java.util.List;

import com.devIt.crmef.models.Reclamation;



public interface reclamationService {

	Reclamation createReclamation(Reclamation reclamation);

	Reclamation updateReclamation(Reclamation reclamation);

	List<Reclamation> getAllReclamation();

	Reclamation getReclamationById(long recId);

	void deleteReclamation(long recId);

}
