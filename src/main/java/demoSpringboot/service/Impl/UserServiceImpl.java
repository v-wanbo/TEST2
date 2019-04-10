package demoSpringboot.service.Impl;

import com.mysql.jdbc.Connection;

import demoSpringboot.entity.User;
import demoSpringboot.service.UserService;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public List<User> testConnection() { 
		
		String sql = "select * from userInfo";
		
		List<User> list=jdbcTemplate.query(sql, new RowMapper<User>() {
			

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				 User user = new User();

				 user.setId(rs.getInt("id"));

				 user.setName(rs.getString("name"));
 
				 return user; 
			}

		});

		return list;
		/*
		 * List<User> list = new ArrayList(); Connection conn = null; ResultSet
		 * res = null; PreparedStatement prs = null; try {
		 * Class.forName("com.mysql.jdbc.Driver");
		 * 
		 * String user = "root"; String password = "1213"; conn = (Connection)
		 * DriverManager.getConnection( "jdbc:mysql://192.168.1.5:3306/user",
		 * user, password); System.out.println("连接对象为："+conn); String sql =
		 * "select * from userInfo"; prs = conn.prepareStatement(sql);
		 * 
		 * res = prs.executeQuery(); while (res.next()) { User userInfo = new
		 * User(); userInfo.setId(res.getInt("id"));
		 * userInfo.setName(res.getString("name")); list.add(userInfo); }
		 * System.out.println("查询数据为："+list.size()); return list; } catch
		 * (Exception e) { System.out.println("出错了，错误信息为：" + e.getMessage());
		 * return null; } finally { try { res.close(); conn.close();
		 * prs.close(); System.out.println("ִ执行完成----------------"); } catch
		 * (SQLException e) { e.printStackTrace(); } }
		 */
	}

	@Override
	public List<User> GetUserInfo() {
		try {
			return testConnection();
		} catch (Exception e) {
		}
		return null;
	}

}
