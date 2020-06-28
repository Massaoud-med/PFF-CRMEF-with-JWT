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

import com.devIt.crmef.models.Cours;
import com.devIt.crmef.servicesImpl.CoursServiceImpl;

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

public class CoursController {

	/**
	 * using @Autowired (to do constructor injection)
	 */
	@Autowired
	private CoursServiceImpl coursServiceImpl;

	@GetMapping("/Cours")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Cours>> getAllCours() {
		return ResponseEntity.ok().body(coursServiceImpl.getAllCours());
	}

	/**
	 * @param id
	 * @return stagiaire par son Id http://localhost:8080/api/v1/stagiaire/id
	 */

	@GetMapping("/Cours/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Cours> getCoursById(@PathVariable("id") long idCours) {
		return ResponseEntity.ok().body(coursServiceImpl.getCoursById(idCours));
	}

	/**
	 * Ajouter un ou plusieurs stagiaire, enoyer avec la methode Post
	 * http://localhost:8080/api/v1/stagiaire
	 * 
	 * @param stagiaire
	 * @return
	 * This process is only allowed for the administrator
	 */

	@PostMapping("/Cours")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Cours> createReclamation(@RequestBody Cours cours) {
		return ResponseEntity.ok().body(this.coursServiceImpl.createCours(cours));
	}

	/**
	 * @param id
	 * @param reclamation
	 * @return ResponseEntity qui contient la modification que j'ai fait sur un
	 *         stagiaire, enoyer avec la methode Put.
	 *         http://localhost:8080/api/v1/stagiaire
	 * 		   This process is only allowed for the administrator
	 */

	@PutMapping("/Cours/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Cours> updateCours(@PathVariable("id") long idCours, @RequestBody Cours cours) {
		cours.setIdCours(idCours);
		return ResponseEntity.ok().body(this.coursServiceImpl.updateCours(cours));
	}

	/**
	 * @param id
	 * @return un message "ok" si il est supprimé ce stagiaire avec id
	 *         http://localhost:8080/api/v1/stagiaire/id
	 *         
	 *         This process is only allowed for the administrator
	 */

	@DeleteMapping("/Cours/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteCours(@PathVariable("id") long idCours) {
		this.coursServiceImpl.deleteCours(idCours);

		return "OK";
	}

}
