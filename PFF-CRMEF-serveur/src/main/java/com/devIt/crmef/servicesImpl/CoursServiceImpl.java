package com.devIt.crmef.servicesImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devIt.crmef.models.Cours;
import com.devIt.crmef.repository.CoursRepository;
import com.devIt.crmef.services.CoursService;

@Service
@Transactional
public class CoursServiceImpl  implements CoursService{
	
	@Autowired
	private CoursRepository courRep;
	

	@Override
	public Cours createCours(Cours cours) {

		return this.courRep.save(cours);
	}

	@Override
	public Cours updateCours(Cours cours) {

		Optional<Cours> courBD = this.courRep.findById(cours.getIdCours());

		if (courBD.isPresent()) {

			Cours coursUpdate = courBD.get();

			coursUpdate.setIdCours(cours.getIdCours());
			coursUpdate.setNomCours(cours.getNomCours());
			coursUpdate.setFormateurCours(cours.getFormateurCours());
			coursUpdate.setSalleCours(cours.getSalleCours());
			coursUpdate.setFiliereCours(cours.getFiliereCours());
			coursUpdate.setDateCours(cours.getDateCours());
			courRep.save(coursUpdate);

			return coursUpdate;
		} else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException(
					"Enregistrement introuvable avec l'identifiant : " + cours.getIdCours());
		}

	}

	@Override
	public List<Cours> getAllCours() {

		return this.courRep.findAll();
	}

	@Override
	public Cours getCoursById(long idCours) {

		Optional<Cours> existe = courRep.findById(idCours);

		if (existe.isPresent()) {

			return existe.get();
		} else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException(
					"Enregistrement introuvable avec l'identifiant : " + idCours);

		}

	}

	@Override
	public void deleteCours(long idCours) {

		Optional<Cours> existe = this.courRep.findById(idCours);

		if (existe.isPresent()) {
			this.courRep.delete(existe.get());
		} else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException(
					"Enregistrement introuvable avec l'identifiant: " + idCours);
		}
		
	}

}
