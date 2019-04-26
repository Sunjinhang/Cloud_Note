package com.sjh.cloud_note.service;

import com.sjh.cloud_note.entity.User;
import com.sjh.cloud_note.util.NoteResult;

public interface UserService {
	//验证用户的登录
	public NoteResult<User> checkLogin(String name,String password);
	//添加用户
	public NoteResult<User> addUser(String name,String password,String nick);
	//修改密码
	public NoteResult<Object> changeUser(String userName,String last_password,String final_password);
}
