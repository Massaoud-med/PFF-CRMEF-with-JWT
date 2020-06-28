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

import com.devIt.crmef.models.Formateur;
import com.devIt.crmef.servicesImpl.formateurServiceImpl;

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

public class formateurControlleur {
	
	@Autowired
	private formateurServiceImpl formateurServiceImpl;
 
	
		/**
		 * @return
		 *  Using Spring ResponseEntity to Manipulate the HTTP Response
		 * This process is only allowed for the administrator
		 */
		@GetMapping("/formateurs")
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<List<Formateur>> getAllFormateur() {
			return ResponseEntity.ok().body(formateurServiceImpl.getAllFormateur());
		}
		
		
	    /**
	     * @param idFormateur
	     * @return
	     *  Using Spring ResponseEntity to Manipulate the HTTP Response
	     * This process is only allowed for the administrator and formateur
	     */
	    @GetMapping("/formateurs/{id}")
		@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
		public ResponseEntity<Formateur> getFormateurById(@PathVariable("id") long idFormateur) {
			return ResponseEntity.ok().body(formateurServiceImpl.getFormateurById(idFormateur));
        }
	    
        
		
	    /**
	     * @param formateur
	     * @return
	     */
	    @PostMapping("/formateurs")
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<Formateur> createFormateur(@RequestBody Formateur formateur) {
			return ResponseEntity.ok().body(this.formateurServiceImpl.createFormateur(formateur));
	    }

	
	    /**
	     * @param idformateur
	     * @param formateur
	     * @return
	     */
	    @PutMapping("/formateurs/{id}")
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<Formateur> updateFormateurs(@PathVariable("id") long idformateur,
				@RequestBody Formateur formateur) {
	    	formateur.setIdformateur(idformateur);
			return ResponseEntity.ok().body(this.formateurServiceImpl.updateFormateur(formateur));	
	        }
	  
	    /**
	     * @param idFormateur
	     * @return
	     */
	    @DeleteMapping("/formateurs/{id}")
		@PreAuthorize("hasRole('ADMIN')")
	    public String deleteFormateur(@PathVariable("id") long idFormateur) {
			this.formateurServiceImpl.deleteFormateur(idFormateur);

			return "OK";
	        }

}
