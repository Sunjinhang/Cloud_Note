package com.sjh.cloud_note.dao;

import java.util.List;
import java.util.Map;

import com.sjh.cloud_note.entity.Note;

public interface NoteDao {

	public List<Map> findByBookId(String bookId);
	
	public Note findByNoteId(String id);
	
	public int updateNote(Note note);
	
	public void save(Note note);
	
	public int dynamicUpdate(Note note);
}
