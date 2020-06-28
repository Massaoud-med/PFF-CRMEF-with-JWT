package com.devIt.crmef.services;

import java.util.List;

import com.devIt.crmef.models.Bibliotheque;



public interface bibliothequeService {
	
	Bibliotheque createBibliotheque(Bibliotheque bibliotheque);

	Bibliotheque updateBibliotheque(Bibliotheque bibliotheque);

	List<Bibliotheque> getAllBibliotheque();

	Bibliotheque getBibliothequeById(long idBib);

	void deleteBibliotheque(long idBib);

}
