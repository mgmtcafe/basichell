package com.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.UserDao;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserId {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/getUserById/{id}")
	public Object getCodeById(@PathVariable("id") String getId){
		Map<String, Object> status = new HashMap<String, Object>();
		boolean parsable = true;
		try{
			Integer.valueOf(getId);
		}catch(NumberFormatException e){
			status.put("status", "error");
			status.put("message", "Only numeric id allowed");
			System.out.println("entered");
			parsable = false;
		}
		finally{
			if(parsable) {
				Object obj = userDao.getUserById(Integer.parseInt(getId));
				if(obj == null){
					status.put("status", "error");
					status.put("message", "No user found for given id");
				}
				else{
					status.put("status", "OK");
					status.put("message", userDao.getUserById(Integer.parseInt(getId)));
				}
			}
		}
		return status;
	}
	@PostMapping("/createUser")
	public boolean createVendor(@RequestBody Map<String,String> userData) {

		return userDao.createUser(userData);
	
	}

	
}
