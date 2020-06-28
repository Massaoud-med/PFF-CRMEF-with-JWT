package com.devIt.crmef.servicesImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devIt.crmef.models.Filiere;
import com.devIt.crmef.repository.FilierRepository;
import com.devIt.crmef.services.filierService;


@Service
@Transactional
public class filierServiceImpl  implements filierService{

	
	@Autowired
	private FilierRepository filierRepo;
	
	
	@Override
	public List<Filiere> getAllFiliere() {
		
		return this.filierRepo.findAll();
	}

	@Override
	public Filiere getFiliereById(long idF) {
		
	Optional<Filiere> fi=this.filierRepo.findById(idF);
		
		if(fi.isPresent()) {return fi.get();}
		else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException(
					"Enregistrement introuvable avec l'identifiant : " + idF);
		}
	
	}

}
