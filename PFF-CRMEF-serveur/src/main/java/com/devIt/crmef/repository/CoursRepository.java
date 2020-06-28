package com.devIt.crmef.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devIt.crmef.models.Cours;


@Repository
public interface CoursRepository  extends JpaRepository<Cours, Long>{

}
