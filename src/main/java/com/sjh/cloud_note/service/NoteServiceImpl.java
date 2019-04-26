package com.sjh.cloud_note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjh.cloud_note.dao.NoteDao;
import com.sjh.cloud_note.entity.Note;
import com.sjh.cloud_note.util.NoteResult;
import com.sjh.cloud_note.util.NoteUtil;

@Service("noteService")
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@Resource
	private NoteDao noteDao;

	//根据笔记本加载笔记
	public NoteResult<List<Map>> loadNotesByBookId(String bookId) {
		NoteResult<List<Map>> result = new NoteResult<List<Map>>();
		List<Map> list = noteDao.findByBookId(bookId);
		result.setStatus(0);
		result.setMsg("笔记加载成功");
		result.setData(list);
		return result;
	}

	//根据笔记id加载笔记
	public NoteResult<Note> loadNoteByNoteId(String noteId) {
		NoteResult<Note> result = new NoteResult<Note>();
		
		Note note = noteDao.findByNoteId(noteId);
		result.setStatus(0);
		result.setMsg("笔记加载成功");
		result.setData(note);
		return result;
	}

	//添加笔记
	public NoteResult<Note> AddNote(String userId, String bookId, String title) {
		NoteResult<Note> result = new NoteResult<Note>();
		Note note = new Note();
		String noteId = NoteUtil.createId();
		
		long time = System.currentTimeMillis();
		note.setCn_note_id(noteId);
		note.setCn_user_id(userId);
		note.setCn_notebook_id(bookId);
		note.setCn_note_title(title);
		note.setCn_note_body("");
		note.setCn_note_create_time(time);
		note.setCn_note_last_modify_time(time);
		note.setCn_note_type_id("1");
		note.setCn_note_status_id("1");
		noteDao.save(note);
		
		result.setStatus(0);
		result.setMsg("添加笔记成功");
		result.setData(note);		
		return result;
	}
 
	//删除笔记
	public NoteResult<Object> DeleteNote(String noteId){
		NoteResult<Object> result = new NoteResult<Object>();
		
		Note note = noteDao.findByNoteId(noteId);
		
		note.setCn_note_status_id("2");
		int rows =  noteDao.dynamicUpdate(note);
		if(rows >= 1) {
			result.setStatus(0);
			result.setMsg("删除笔记成功");
		}
		else {
			result.setStatus(1);
			result.setMsg("删除笔记失败");
		}		
		return result;
	}

	//更新笔记标题或者笔记内容
	public NoteResult<Object> UpdateNote(String noteId, String title, String body) {
		NoteResult<Object> result = new NoteResult<Object>();
		Note note = noteDao.findByNoteId(noteId);
		
		long time = System.currentTimeMillis();
		note.setCn_note_title(title);
		note.setCn_note_body(body);
		note.setCn_note_last_modify_time(time);
		
		int rows = noteDao.dynamicUpdate(note);
		if(rows >= 1) {
			result.setStatus(0);
			result.setMsg("笔记更新成功");
		}
		else {
			result.setStatus(1);
			result.setMsg("笔记更新失败");
		}
		return result;
	}

	//移动笔记到其他笔记本
	public NoteResult<Object> MoveNote(String noteId, String bookId) {
		
		NoteResult<Object> result = new NoteResult<Object>();
		Note note = noteDao.findByNoteId(noteId);
		
		note.setCn_notebook_id(bookId);
		int rows = noteDao.dynamicUpdate(note);
		
		if(rows >= 1) {
			result.setStatus(0);
			result.setMsg("笔记移动成功");
		}
		else {
			result.setStatus(1);
			result.setMsg("笔记移动失败");
		}
		return result;
	}
}
