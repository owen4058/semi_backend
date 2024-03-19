package com.spring.myapp.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;

public interface MemberController {
	public ResponseEntity<String> login(@RequestBody LoginForm loginForm, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity<String> save(@RequestBody Member member, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity<String> edit(Member member,  HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity<String> delete(@RequestBody LoginForm loginForm,  HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity<String> idValidate(@RequestBody Member idValidate, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
	
	public ResponseEntity<String> logout(HttpServletRequest request) throws Exception;

}
