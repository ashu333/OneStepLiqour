package com.springboot.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


public interface OneStepLiquorRepository {

	public Boolean Register(String Name,String email,String phne,String address,String IndentityType ,
			String IndentityNo , String dob , String password,JdbcTemplate jdbcTemplate);
}
