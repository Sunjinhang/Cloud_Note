package com.sjh.cloud_note.service;

import java.util.List;

import com.sjh.cloud_note.entity.Share;
import com.sjh.cloud_note.util.NoteResult;

public interface ShareService {

	//添加分享
	public NoteResult<Object> AddShare(String noteId);
	
	
	//根据标题查找分享
	public NoteResult<List<Share>> findLikeTitle(String title);
	
	//根据Id查找分享
	public NoteResult<Share> findById(String id);
}
