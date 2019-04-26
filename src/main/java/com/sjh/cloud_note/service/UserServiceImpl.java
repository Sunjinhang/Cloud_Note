package com.sjh.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjh.cloud_note.dao.UserDao;
import com.sjh.cloud_note.entity.User;
import com.sjh.cloud_note.util.NoteResult;
import com.sjh.cloud_note.util.NoteUtil;

@Service("userService") //扫描spring容器
@Transactional
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	

	public NoteResult<User> checkLogin(String name, String password) {
		//接受操做之后的结果
		NoteResult<User> result=new NoteResult<User>();
		//调用UserMapper中的查询，并且以User的形式返回查询结果。
		User user = userDao.findByName(name);
		//判断该用户是否存在
		if(user==null) {
			result.setStatus(1);
			result.setMsg("未找到该用户");
			return result;
		}
		//密码加密，并且比较密码是否一致
		String md5Password=NoteUtil.md5(password);//MD5加密
		if(!user.getCn_user_password().equals(md5Password)) {
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		//返回验证的结果
		result.setStatus(0);
		result.setMsg("登陆成功");
		result.setData(user);
		return result;
	}
	
	//注册用户
	public NoteResult<User> addUser(String name, String password, String nick) {
		//接受操作之后的结果
		NoteResult<User> result = new NoteResult<User>();
		//查询数据库
		User hasUser = userDao.findByName(name);
		//判断该用户名称是否已经存在
		if(hasUser!=null) {
			result.setStatus(1);
			result.setMsg("该用户已经存在，请更换注册名称");
			return result;
		}

		User user = new User();	
		user.setCn_user_name(name);
		
		//对密码进行加密
		String md5Password = NoteUtil.md5(password);
		user.setCn_user_password(md5Password);

		user.setCn_user_nick(nick);
		
		//生成随机的id
		String id = NoteUtil.createId();
		user.setCn_user_id(id);
		
		
		//保存用户
		userDao.save(user);
		
		
		//返回操作之后的结果
		result.setStatus(0);
		result.setMsg("用户注册成功");
		return result;
	}	
	
	//更改密码
	public NoteResult<Object> changeUser(String userName, String last_password, String final_password) {

		NoteResult<Object> result=new NoteResult<Object>();
		//按照用户名进行查询
		User user = userDao.findByName(userName);
		//获取用户密码
		String user_password = user.getCn_user_password();
		//密码加密
		last_password=NoteUtil.md5(last_password);
		final_password=NoteUtil.md5(final_password);
		System.out.println(user_password);
		System.out.println(last_password);
		System.out.println(final_password);
		//判断密码是否一致
		if(!user_password.equals(last_password)) {
			result.setStatus(1);
			result.setMsg("密码不一致，请重新填写");
			return result;
		}else if(user_password.equals(final_password)) {
			result.setStatus(2);
			result.setMsg("新密码不能和旧密码一致，请重新填写");
			return result;
		}else{
			//返回操作结果
			user.setCn_user_password(final_password);
			userDao.change(user);
			result.setStatus(0);
			result.setMsg("密码修改成功");
			return result;
		}
	}
	

}
