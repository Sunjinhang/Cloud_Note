package com.sjh.cloud_note.service;

import java.util.List;
import java.util.Map;

import com.sjh.cloud_note.entity.Note;
import com.sjh.cloud_note.util.NoteResult;

public interface NoteService {

	public NoteResult<List<Map>> loadNotesByBookId(String bookId);
	
	public NoteResult<Note> loadNoteByNoteId(String noteId);
	
	public NoteResult<Note> AddNote(String userId,String bookId,String title);
	
	public NoteResult<Object> DeleteNote(String noteId);
	
	public NoteResult<Object> UpdateNote(String noteId,String title,String body);
	
	public NoteResult<Object> MoveNote(String noteId,String bookId);
	
	
}
