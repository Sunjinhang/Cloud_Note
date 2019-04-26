package com.sjh.cloud_note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjh.cloud_note.dao.NoteDao;
import com.sjh.cloud_note.dao.ShareDao;
import com.sjh.cloud_note.entity.Note;
import com.sjh.cloud_note.entity.Share;
import com.sjh.cloud_note.util.NoteResult;
import com.sjh.cloud_note.util.NoteUtil;

@Service("shareService")
@Transactional
public class ShareServiceImpl implements ShareService {

	@Resource
	private ShareDao shareDao;
	
	@Resource
	private NoteDao noteDao;

	public NoteResult<Object> AddShare(String noteId) {
		NoteResult<Object> result = new NoteResult<Object>();
		
		Share share = new Share();
		
		String shareId = NoteUtil.createId();
		share.setCn_share_id(shareId);
		share.setCn_note_id(noteId);

		Note note = noteDao.findByNoteId(noteId);
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_share_body(note.getCn_note_body());
		
		shareDao.share(share);
		
		result.setStatus(0);
		result.setMsg("分享笔记成功");
		
		return result;
	}

	public NoteResult<List<Share>> findLikeTitle(String title) {
		NoteResult<List<Share>> result = new NoteResult<List<Share>>();
		
		List<Share> list = shareDao.findLikeTitle(title);
		
		result.setData(list);
		result.setStatus(0);
		result.setMsg("加载分享笔记成功");
		return result;
	}
	

	public NoteResult<Share> findById(String id) {
		NoteResult<Share> result = new NoteResult<Share>();
		
		Share share = shareDao.findById(id);
		result.setStatus(0);
		result.setMsg("获取分享笔记成功");
		result.setData(share);
		return result;
	}
	
	
}
