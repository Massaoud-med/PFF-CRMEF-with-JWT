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

import com.devIt.crmef.models.Departement;
import com.devIt.crmef.servicesImpl.departementServiceImpl;

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
public class departementController {
 
	/**
	 * using @Autowired (to do constructor injection)
	 */
	@Autowired
	private departementServiceImpl departementServiceImpl;

	
	/**
	 * @return
	 * 	 * Using Spring ResponseEntity to Manipulate the HTTP Response
	 * This process is only allowed for the administrator
	 */
	@GetMapping("/departemnts")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Departement>> getAllDepartement() {
		return ResponseEntity.ok().body(departementServiceImpl.getAllDepartement());
	}
	

	/**
	 * @param idDepartement
	 * @return
	 * 	 * Using Spring ResponseEntity to Manipulate the HTTP Response
	 *   This process is only allowed for the administrator
	 */
	@GetMapping("/departemnts/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Departement> getDepartementById(@PathVariable("id") long idDepartement) {
		return ResponseEntity.ok().body(departementServiceImpl.getDepartementById(idDepartement));
	}

	
	/**
	 * @param departement
	 * @return
	 * 	 * Using Spring ResponseEntity to Manipulate the HTTP Response
	 *   This process is only allowed for the administrator
	 */
	@PostMapping("/departemnts")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) {
		return ResponseEntity.ok().body(this.departementServiceImpl.createDepartement(departement));
	}

	/**
	 * @param idDep
	 * @param departement
	 * @return
	 * 	 * Using Spring ResponseEntity to Manipulate the HTTP Response
	 * 	   This process is only allowed for the administrator
	 */
	@PutMapping("/departemnts/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Departement> updateDepertemnts(@PathVariable("id") long idDep,
			@RequestBody Departement departement) {
		departement.setIdDep(idDep);
		;
		return ResponseEntity.ok().body(this.departementServiceImpl.updateDepartement(departement));
	}

	/**
	 * @param idDepartement
	 * @return
	 * 	 * Using Spring ResponseEntity to Manipulate the HTTP Response
	 *     This process is only allowed for the administrator
	 */
	@DeleteMapping("/departemnts/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deletedepertemnt(@PathVariable("id") long idDepartement) {
		this.departementServiceImpl.deleteDepartement(idDepartement);

		return "OK";
	}

}
