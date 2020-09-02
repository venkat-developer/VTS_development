package com.sansol.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sansol.model.Login;
import com.sansol.model.User;

public class UserDaoImpl implements UserDao {
	public JdbcTemplate getJdbcTemplate() {
	    return jdbcTemplate;
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	public int register(User user) {
		String sql = "insert into users values(?,?,?,?,?,?,?)";

		return jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
				user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
	}

	public User validateUser(Login login) {
		String sql = "select * from users where username='" + login.getUsername() + "' and password='"
				+ login.getPassword() + "'";
		System.out.println("Template is "+jdbcTemplate);
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		System.err.println(users);
		return users.size() > 0 ? users.get(0) : null;
	}
}

class UserMapper implements RowMapper {

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();

		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setPhone(rs.getInt("phone"));

		return user;
	}

}
