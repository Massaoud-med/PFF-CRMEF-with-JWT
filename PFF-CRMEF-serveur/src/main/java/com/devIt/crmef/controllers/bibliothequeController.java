package com.devIt.crmef.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devIt.crmef.models.Bibliotheque;
import com.devIt.crmef.servicesImpl.bibliothequeServiceImpl;

/**
 * @author ZAROUQ
 * Date: 11/06/2020
 * version v1.0
 * mission : application web pour la gestion du Centre Régional des Métiers de l'Education et de la Formation (CRMEF).
 */
@RestController
//CrossOriginest est un mécanisme qui permet partage de ressources entre origines multiples.
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1")


public class bibliothequeController {

	/** 
	 * using @Autowired (to do constructor injection)
	 */
	@Autowired
	private bibliothequeServiceImpl bibliothequeServiceImpl;

	
	/**
	 * @return
	 * Using Spring ResponseEntity to Manipulate the HTTP Response
	 * This process is only allowed for the administrator
	 */
	@GetMapping("/bibliotheque")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Bibliotheque>> getAllbibliotheque() {
		return ResponseEntity.ok().body(bibliothequeServiceImpl.getAllBibliotheque());
	}

	/**
	 * @param idBib
	 * @return
	 * Using Spring ResponseEntity to Manipulate the HTTP Response
	 * This process is only allowed for the administrator
	 */
	@GetMapping("/bibliotheque/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Bibliotheque> getBibliothequeById(@PathVariable("id") long idBib) {
		return ResponseEntity.ok().body(bibliothequeServiceImpl.getBibliothequeById(idBib));
	}

	/**
	 * @param bibliotheque
	 * @return
	 * Using Spring ResponseEntity to Manipulate the HTTP Response
	 * This process is only allowed for the administrator
	 */
	@PostMapping("/bibliotheque")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Bibliotheque> createBibliotheque(@RequestBody Bibliotheque bibliotheque) {
		return ResponseEntity.ok().body(this.bibliothequeServiceImpl.createBibliotheque(bibliotheque));
	}

	/**
	 * @param idBib
	 * @param bibliotheque
	 * @return
	 * Using Spring ResponseEntity to Manipulate the HTTP Response
	 * This process is only allowed for the administrator
	 */
	@PutMapping("/bibliotheque/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Bibliotheque> updateFormateurs(@PathVariable("id") long idBib,
			@RequestBody Bibliotheque bibliotheque) {
		bibliotheque.setIdBib(idBib);
		return ResponseEntity.ok().body(this.bibliothequeServiceImpl.updateBibliotheque(bibliotheque));
	}

	/**
	 * @param idBib
	 * @return
	 * Using Spring ResponseEntity to Manipulate the HTTP Response
	 * This process is only allowed for the administrator
	 */
	@DeleteMapping("/bibliotheque/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBibliotheque(@PathVariable("id") long idBib) {
		this.bibliothequeServiceImpl.deleteBibliotheque(idBib);

		return "OK";
	}

}
