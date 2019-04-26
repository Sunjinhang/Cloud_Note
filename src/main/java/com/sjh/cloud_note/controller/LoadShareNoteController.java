package com.sjh.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.cloud_note.entity.Share;
import com.sjh.cloud_note.service.ShareService;
import com.sjh.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class LoadShareNoteController {
	@Resource
	private ShareService shareService;
	
	@RequestMapping("/load_share.do")
	@ResponseBody
	public NoteResult<Share> execute(String shareId){
		NoteResult<Share> result = shareService.findById(shareId);
		return result;
	}

}
