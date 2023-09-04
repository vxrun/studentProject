package com.springb.students.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springb.students.bean.LoginBean;

@RestController
public class LoginController {
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<LoginBean> handleLogin(LoginBean loginBean){
		return ResponseEntity.ok().body(loginBean);
	}
}
