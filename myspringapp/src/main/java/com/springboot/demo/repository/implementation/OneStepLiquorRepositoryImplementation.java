package com.springboot.demo.repository.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.demo.repository.OneStepLiquorRepository;

@Repository
public class OneStepLiquorRepositoryImplementation implements OneStepLiquorRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Boolean Register(String Name, String email, String phne, String address, String IndentityType,
			String IndentityNo, String dob, String password, JdbcTemplate jdbcTemplate1) {

		this.jdbcTemplate = jdbcTemplate1;
		
		String sql = "INSERT INTO `OneStepLiquor`.`UserTable` (`Name`, `email_address`, `PhoneNo`, `address`, `Identity_Type`, `Identity_No.`, `dob`, `password`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		int result = jdbcTemplate.update(sql, Name, email, phne, address, IndentityType, IndentityNo, dob,
				password);

		if (result > 0) {
			return true;
		}

		return false;
	}

}
