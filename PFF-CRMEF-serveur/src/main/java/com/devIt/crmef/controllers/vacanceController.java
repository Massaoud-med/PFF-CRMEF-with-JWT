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

import com.devIt.crmef.models.Vacance;
import com.devIt.crmef.servicesImpl.vacanceServiceImp;

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
@PreAuthorize("hasRole('ADMIN')")
public class vacanceController {

	@Autowired
	private vacanceServiceImp serviceImp;

	/**
	 * @return
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/vacance")
	public ResponseEntity<List<Vacance>> getAllVacance() {
		return ResponseEntity.ok().body(serviceImp.getAllVacance());
	}

	/**
	 * @param idVac
	 * @return
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/vacance/{id}")
	public ResponseEntity<Vacance> getvacanceById(@PathVariable("id") long idVac) {
		return ResponseEntity.ok().body(serviceImp.getVacanceById(idVac));
	}

	/**
	 * @param vacance
	 * @return
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/vacance")
	public ResponseEntity<Vacance> createVacance(@RequestBody Vacance vacance) {
		return ResponseEntity.ok().body(this.serviceImp.createVacance(vacance));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/vacance/{id}")
	public ResponseEntity<Vacance> updateVacance(@PathVariable("id") long idVac, @RequestBody Vacance vacance) {
		vacance.setIdVac(idVac);
		return ResponseEntity.ok().body(this.serviceImp.updateVacance(vacance));
	}

	/**
	 * @param idVac
	 * @return
	 */

	@DeleteMapping("/vacance/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBibliotheque(@PathVariable("id") long idVac) {
		this.serviceImp.deleteVacance(idVac);
		;

		return "OK";
	}

}
