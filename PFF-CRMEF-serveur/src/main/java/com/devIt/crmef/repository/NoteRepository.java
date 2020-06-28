package com.devIt.crmef.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devIt.crmef.models.Note;


@Repository
public interface NoteRepository  extends JpaRepository<Note, Long>{

}
