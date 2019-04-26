package com.sjh.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.cloud_note.entity.User;
import com.sjh.cloud_note.service.UserService;
import com.sjh.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")//匹配请求路径
public class UserLoginController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/login.do")//匹配请求
	@ResponseBody
	public NoteResult<User> execute(String name,String password){
		//调用UserService处理登录请求
		System.out.println(name+","+password);
		NoteResult<User> result = userService.checkLogin(name, password);
		return result;
	}
}