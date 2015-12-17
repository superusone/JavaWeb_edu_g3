package cn.zjxu.exam.user.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.zjxu.exam.user.domain.User;

public class UserDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<User> findAll(int mark) {
		try {
			String sql = "select * from edu_user where mark=" + mark;
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 通过名字查询
	 * 
	 * @param name
	 * @return
	 */
	public User findByUsername(String name) {
		try {
			String sql = "select * from edu_user where name=?";
			return qr.query(sql, new BeanHandler<User>(User.class), name);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 通过id查询
	 * 
	 * @param name
	 * @return
	 */
	public User findByUserId(String id) {
		try {
			String sql = "select * from edu_user where id=?";
			return qr.query(sql, new BeanHandler<User>(User.class), id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 编辑用户
	 * 
	 * @param u
	 */
	public void edit(User u) {
		try {
			String sql = "update edu_user set `name`=?,`password`=?,sex=?,age=?,mark=? where id=?";
			Object[] params = { u.getName(), u.getPassword(), u.getSex(),
					u.getAge(), u.getMark(), u.getId() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除用户
	 * 
	 * @param u
	 */
	public void delete(User u) {
		// 伪删除吧记录抹掉

		try {
			String sql = "DELETE FROM `edu`.`edu_user` WHERE `id`=?";
			Object[] params = { u.getId() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 删除用户
	 * 
	 * @param u
	 */
	public void delete(String id) {
		// 伪删除吧记录抹掉
		
		try {
			String sql = "DELETE FROM `edu`.`edu_user` WHERE `id`=?";
			Object[] params = { id };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 插入User
	 * 
	 * @param user
	 */
	public void add(User user) {
		try {
			String sql = "insert into edu_user values(?,?,?,?,?,?)";
			Object[] params = { user.getId(), user.getName(),
					user.getPassword(), user.getSex(), user.getAge(),
					user.getMark() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改指定用户的指定状态
	 * 
	 * @param id
	 * @param mark
	 */
	public void updateMark(String id, int mark) {
		try {
			String sql = "update edu_user set mark=? where id=?";
			qr.update(sql, mark, id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int getMark(String id){
		try {
			String sql = "select * from edu_user where id=?";
			User user = qr.query(sql, new BeanHandler<User>(User.class), id);
			return user.getMark();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
