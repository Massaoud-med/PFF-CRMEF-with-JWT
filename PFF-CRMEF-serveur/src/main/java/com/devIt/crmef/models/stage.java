package com.devIt.crmef.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class stage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idStage;


}
