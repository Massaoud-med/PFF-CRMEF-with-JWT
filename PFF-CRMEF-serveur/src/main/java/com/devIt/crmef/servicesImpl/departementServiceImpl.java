package com.devIt.crmef.servicesImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devIt.crmef.models.Departement;
import com.devIt.crmef.repository.DepartementRepository;
import com.devIt.crmef.services.departementService;

@Service
@Transactional
public class departementServiceImpl  implements departementService{

	@Autowired
	private DepartementRepository departementRepository;
	
	@Override
	public Departement createDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public Departement updateDepartement(Departement departement) {
		
		Optional<Departement> departementDB =this.departementRepository.findById(departement.getIdDep());
		
		if(departementDB.isPresent()) {
			
			Departement departementUpdate=departementDB.get();
			departementUpdate.setIdDep(departement.getIdDep());
			departementUpdate.setNomDep(departement.getNomDep());
			departementUpdate.setResponsableDep(departement.getResponsableDep());
			departementUpdate.setTeleDep(departement.getTeleDep());
			departementUpdate.setEmailDep(departement.getEmailDep());
			departementUpdate.setCapaciteDep(departement.getCapaciteDep());
			departementRepository.save(departementUpdate);
		
			return departementUpdate;
		} else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException(
					"Enregistrement introuvable avec id : " + departement.getIdDep());
		}
	}

	@Override
	public List<Departement> getAllDepartement() {
		return departementRepository.findAll();
	}

	@Override
	public Departement getDepartementById(long idDepartement) {

		Optional<Departement> f=this.departementRepository.findById(idDepartement);
		
		if(f.isPresent()) {return f.get();}
		else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException(
					"Enregistrement introuvable avec id : " + idDepartement);
		}

	}

	@Override
	public void deleteDepartement(long idDepartement) {

	Optional<Departement> f=this.departementRepository.findById(idDepartement);
		
		if(f.isPresent()) { this.departementRepository.delete(f.get());}
		else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException(
					"Enregistrement introuvable avec id : " + idDepartement);
		}
		
	}
	

}
