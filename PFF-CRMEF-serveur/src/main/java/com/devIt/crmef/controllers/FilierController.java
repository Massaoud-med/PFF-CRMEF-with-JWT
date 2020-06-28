package com.devIt.crmef.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devIt.crmef.models.Filiere;
import com.devIt.crmef.servicesImpl.filierServiceImpl;

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
public class FilierController {
	
	/** 
	 * using @Autowired (to do constructor injection)
	 */
	@Autowired
	private filierServiceImpl f;

	
	/**
	 * @return
	 * Using Spring ResponseEntity to Manipulate the HTTP Response
	 * This process is only allowed for the administrator
	 */
	@GetMapping("/filiers")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Filiere>> getAllFiliers() {
		return ResponseEntity.ok().body(f.getAllFiliere());
    }
	
	
    /**
     * @param idFil
     * @return
     * Using Spring ResponseEntity to Manipulate the HTTP Response
	 * This process is only allowed for the administrator
     */
    @GetMapping("/filiers/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Filiere> getFilierById(@PathVariable("id") long idFil) {
		return ResponseEntity.ok().body(f.getFiliereById(idFil));
    }
    
}
