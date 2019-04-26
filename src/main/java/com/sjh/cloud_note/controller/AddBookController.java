package com.sjh.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.cloud_note.entity.Book;
import com.sjh.cloud_note.service.BookService;
import com.sjh.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")
public class AddBookController {

	@Resource
	private BookService bookService;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Book> execute(String userId,String title){	
		NoteResult result = bookService.AddBook(userId, title);
		return result;
	}
}
