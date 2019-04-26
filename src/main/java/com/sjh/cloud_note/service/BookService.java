package com.sjh.cloud_note.service;


import java.util.List;

import com.sjh.cloud_note.entity.Book;
import com.sjh.cloud_note.util.NoteResult;

public interface BookService {
	public  NoteResult<List<Book>> loadBooks(String userId);
	
	public NoteResult<Book> AddBook(String userId,String title);
}
