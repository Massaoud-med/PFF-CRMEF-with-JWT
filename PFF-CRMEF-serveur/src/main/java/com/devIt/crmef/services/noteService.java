package com.devIt.crmef.services;

import java.util.List;

import com.devIt.crmef.models.Note;




public interface noteService {

	Note createNote(Note note);

//	Note updateNote(Note note);

	List<Note> getAllNote();

	Note getNoteById(long noteId);

	void deleteNote(long noteId);
}
