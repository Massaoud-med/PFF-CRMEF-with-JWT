package com.devIt.crmef.services;

import java.util.List;

import com.devIt.crmef.models.Departement;



public interface departementService {
	
	Departement createDepartement(Departement departement);

	Departement updateDepartement(Departement departement);

	List<Departement> getAllDepartement();

	Departement getDepartementById(long idDepartement);

	void deleteDepartement(long idDepartement);
}
