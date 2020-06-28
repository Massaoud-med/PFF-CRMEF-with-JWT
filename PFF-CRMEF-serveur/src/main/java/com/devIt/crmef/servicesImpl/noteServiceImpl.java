package com.devIt.crmef.servicesImpl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devIt.crmef.models.Note;
import com.devIt.crmef.repository.NoteRepository;
import com.devIt.crmef.services.noteService;

@Service
@Transactional
public class noteServiceImpl implements noteService{
	
	@Autowired
	private NoteRepository noteRepo;

	@Override
	public Note createNote(Note note) {
		return noteRepo.save(note);
	}

	/*@Override
	public Note updateNote(Note note) {
		Optional<Note> noteDb = this.noteRepo.findById(note.getIdNote());

		if (noteDb.isPresent()) {
			Note noteUpdate = noteDb.get();
			noteUpdate.setNom_stagiaire(note.getNom_stagiaire());;
			noteUpdate.setIdNote(note.getIdNote());
			noteUpdate.setModule_1(note.getModule_1());
			noteUpdate.setModule_2(note.getModule_2());


			noteRepo.save(noteUpdate);
			return noteUpdate;
		} else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException(
					"Enregistrement introuvable avec l'identifiant : " + note.getIdNote());
		}
	}*/

	@Override
	public List<Note> getAllNote() {
		return this.noteRepo.findAll();
	}

	@Override
	public Note getNoteById(long noteId) {
		Optional<Note> reclamationDb = this.noteRepo.findById(noteId);

		if (reclamationDb.isPresent()) {
			return reclamationDb.get();
		} else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException(
					"Enregistrement introuvable avec l'identifiant : " + noteId);
		}
	}

	@Override
	public void deleteNote(long noteId) {
	
		Optional<Note> stgtDb = this.noteRepo.findById(noteId);

		if (stgtDb.isPresent()) {
			this.noteRepo.delete(stgtDb.get());
		} else {
			throw new com.devIt.crmef.Exeption.ResourceNotFoundException(
					"Enregistrement introuvable avec l'identifiant: " + noteId);
		}
		
	}
}
