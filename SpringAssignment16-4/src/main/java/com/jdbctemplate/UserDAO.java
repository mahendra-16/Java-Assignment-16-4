package com.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


public class UserDAO{

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<User> getAllUser(){
		return jdbcTemplate.query("select * from jdbctemplate", new ResultSetExtractor<List<User>>(){

			@Override
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub

				List<User> list = new ArrayList<User>(); 
				while(rs.next()){
					User user = new User();
					user.setId(rs.getInt(1));
					user.setCountry(rs.getString(2));
					list.add(user);
				}
				
				return list;
			}
			
		});
	}

	
}


	