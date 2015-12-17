package cn.zjxu.exam.user.service;

import java.util.List;

import cn.zjxu.exam.user.dao.UserDao;
import cn.zjxu.exam.user.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();

	/**
	 * 注册功能
	 * 
	 * @param form
	 */
	public void regist(User form) throws UserException {

		// 校验用户名
		User user = userDao.findByUsername(form.getName());
		if (user != null)
			throw new UserException("用户名已被注册！");

		// 插入用户到数据库
		userDao.add(form);
	}

	/**
	 * 登录功能
	 * 
	 * @param form
	 * @return
	 * @throws UserException
	 */
	public User login(User form) throws UserException {
		/*
		 * 1. 使用name查询，得到User 
		 * 2. 如果user为null，抛出异常（用户名不存在） 
		 * 3.比较form和user的密码，若不同，抛出异常（密码错误）
		 */
		User user = userDao.findByUsername(form.getName());
		if (user == null)
			throw new UserException("用户名不存在！");
		if (!user.getPassword().equals(form.getPassword()))
			throw new UserException("密码错误！");

		return user;
	}

	/**
	 * 编辑用户
	 * @param form
	 * @return
	 */
	public String Edit(User user){
		userDao.edit(user);
		return "OK!";
	}
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public String delete(User user){
		userDao.delete(user);
		return "OK!";
	}
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public String delete(String id){
		userDao.delete(id);
		return "OK!";
	}
	
	/**
	 * 修改身份标识
	 * @param id
	 * @param mark
	 */
	public void updateMark(String id, int mark){
		userDao.updateMark(id, mark);
	}
	
	public List<User> findAll(int mark){
		List list = userDao.findAll(mark);
		return list;
		
	}
	
	public User findById(String id){
		User user = userDao.findByUserId(id);
		return user;
	}
	
	public int getMark(String id){
		int mark = userDao.getMark(id);
		return mark;
	}
}
