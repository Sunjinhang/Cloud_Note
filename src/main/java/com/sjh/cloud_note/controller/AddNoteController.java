package com.sjh.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.cloud_note.entity.Note;
import com.sjh.cloud_note.service.NoteService;
import com.sjh.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class AddNoteController {

	@Resource
	private NoteService noteService;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Note> execute (String userId,String bookId,String title){
		NoteResult<Note> result = noteService.AddNote(userId, bookId, title);
		return result;
	}
}
