package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.demo.repository.OneStepLiquorRepository;
import com.springboot.demo.repository.implementation.OneStepLiquorRepositoryImplementation;

@Controller
public class OneStepController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@GetMapping("/OneStepLiquorRegister")
	@ResponseBody
	public ResponseEntity<String> OneStepLiquorRegister(@RequestParam String Name,@RequestParam String email,
			@RequestParam String phne,@RequestParam String address,@RequestParam String idtype,
			@RequestParam String idno,@RequestParam String dob,@RequestParam String password) {
		
		/*String getAllSql = "Select * from UserTable";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(getAllSql);

		
		  for(Map<String, Object> row : rows) { for (Entry<String, Object> entry :
		 row.entrySet()) { System.out.println("Key = " + entry.getKey() + ", Value = "
		 + entry.getValue()); }
		 
		 }
		 */
		OneStepLiquorRepository request = new OneStepLiquorRepositoryImplementation();
		boolean result = request.Register(Name, email, phne, address, idtype, idno, dob, password,jdbcTemplate);
		
		if(result) {
			return new ResponseEntity<String>("Inserted successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);

	}

}
