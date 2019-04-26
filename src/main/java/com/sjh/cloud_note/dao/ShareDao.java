package com.sjh.cloud_note.dao;

import java.util.List;

import com.sjh.cloud_note.entity.Share;

public interface ShareDao {
	public void share(Share share);
	
	public List<Share> findLikeTitle(String title);
	
	public Share findById(String id);
}
