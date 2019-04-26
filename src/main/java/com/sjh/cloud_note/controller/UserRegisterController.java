package com.sjh.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.cloud_note.entity.User;
import com.sjh.cloud_note.service.UserService;
import com.sjh.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserRegisterController {

	@Resource
	private UserService userService;
	
	@RequestMapping("add.do")
	@ResponseBody
	public NoteResult<User> execute (String name,String nick,String password){
		NoteResult<User> result = userService.addUser(name, password, nick);
		return result;
	}
}
