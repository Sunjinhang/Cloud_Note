package com.sjh.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.cloud_note.entity.Book;
import com.sjh.cloud_note.service.BookService;
import com.sjh.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")
public class LoadBooksController {
	
	@Resource
	private BookService bookService;

	@RequestMapping("/loadBooks.do")
	@ResponseBody
	public  NoteResult<List<Book>>  execute(String userId){
		
		 NoteResult<List<Book>> result = bookService.loadBooks(userId);
		return result;
	}
}
