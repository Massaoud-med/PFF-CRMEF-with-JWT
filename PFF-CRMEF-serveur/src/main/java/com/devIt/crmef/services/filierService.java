package com.devIt.crmef.services;

import java.util.List;

import com.devIt.crmef.models.Filiere;

public interface filierService {
	
	List<Filiere> getAllFiliere();

	Filiere getFiliereById(long idF);

}
