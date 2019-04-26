package com.sjh.cloud_note.dao;

import com.sjh.cloud_note.entity.User;

public interface UserDao {
	//根据用户名查找用户
	public User findByName(String name);
	//新增用户
	public void save(User user);
	//修改密码
	public void change(User user);
	
	
}
