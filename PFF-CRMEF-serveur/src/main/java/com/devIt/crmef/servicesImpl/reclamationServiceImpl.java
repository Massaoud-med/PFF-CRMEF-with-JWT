package com.devIt.crmef.servicesImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devIt.crmef.models.Reclamation;
import com.devIt.crmef.repository.ReclamationRepository;
import com.devIt.crmef.services.reclamationService;

@Service
@Transactional
public class reclamationServiceImpl implements reclamationService {

	@Autowired
	private ReclamationRepository reclamationRepository;

	@Override
	public Reclamation createReclamation(Reclamation reclamation) {

		return reclamationRepository.save(reclamation);
	}

	@Override
	public Reclamation updateReclamation(Reclamation reclamation) {

		Optional<Reclamation> reclamationDb = this.reclamationRepository.findById(reclamation.getIdRec());

		if (reclamationDb.isPresent()) {
			Reclamation reclamtionUpdate = reclamationDb.get();
			reclamtionUpdate.setIdRec(reclamation.getIdRec());
			reclamtionUpdate.setTypeRec(reclamation.getTypeRec());
			reclamtionUpdate.setDescription(reclamation.getDescription());
			reclamationRepository.save(reclamtionUpdate);
			return reclamtionUpdate;
		} else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException(
					"Enregistrement introuvable avec l'identifiant : " + reclamation.getIdRec());
		}

	}

	@Override
	public List<Reclamation> getAllReclamation() {

		return this.reclamationRepository.findAll();
	}

	@Override
	public Reclamation getReclamationById(long recId) {

		Optional<Reclamation> reclamationDb = this.reclamationRepository.findById(recId);

		if (reclamationDb.isPresent()) {
			return reclamationDb.get();
		} else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException("Enregistrement introuvable avec l'identifiant : " + recId);
		}
	}

	@Override
	public void deleteReclamation(long recId) {

		Optional<Reclamation> productDb = this.reclamationRepository.findById(recId);

		if (productDb.isPresent()) {
			this.reclamationRepository.delete(productDb.get());
		} else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException("Enregistrement introuvable avec l'identifiant: " + recId);
		}

	}

}
