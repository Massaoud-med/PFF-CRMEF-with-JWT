package com.devIt.crmef.services;

import java.util.List;

import com.devIt.crmef.models.Vacance;



public interface vacanceService {
	
	Vacance createVacance(Vacance vacance);

	Vacance updateVacance(Vacance vacance);

	List<Vacance> getAllVacance();

	Vacance getVacanceById(long idVac);

	void deleteVacance(long idVac);

}
