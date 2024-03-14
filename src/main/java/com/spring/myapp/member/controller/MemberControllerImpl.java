package com.spring.myapp.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.idValidate;
import com.spring.myapp.member.service.MemberService;

import oracle.jdbc.proxy.annotation.Post;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	
	@Autowired
	MemberService MemberService;

	@PostMapping("/login")
	@Override
	public ResponseEntity<String> login(@RequestBody LoginForm loginForm, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Member loginmember = MemberService.login(loginForm);
		
		if (loginmember == null) {
            return new ResponseEntity<>("login bad", HttpStatus.NOT_FOUND);
        }
		
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", loginmember);
		
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	@Override
	public ResponseEntity<String> logout(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession(false);	
		 if (session != null) {
	            session.invalidate();
	        }
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
	
	@PostMapping("/assign")
	@Override
	public ResponseEntity<String> save(@RequestBody Member member, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int vo = MemberService.addMember(member);
		
		 if (vo!=1) {
	            return new ResponseEntity<>("bad", HttpStatus.NOT_FOUND);
	        }
		
		
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	@Override
	public ResponseEntity<String> edit(@RequestBody Member member, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int vo = MemberService.updateMember(member);
		
		 if (vo!=1) {
	            return new ResponseEntity<>("bad", HttpStatus.NOT_FOUND);
	        }
		
		
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
	
	@PostMapping("/deletee")
	@Override
	public ResponseEntity<String> delete(@RequestBody LoginForm loginForm, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int vo = MemberService.removeMember(loginForm.getUseraccount());
		 
		 if (vo!=1) {
	            return new ResponseEntity<>("bad", HttpStatus.NOT_FOUND);
	        }
		
		
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
	@Override
	@PostMapping("/useraccount")
	public ResponseEntity<String> idValidate(@RequestBody idValidate idValidate, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("호출");
		idValidate idValidate2 = MemberService.Validate(idValidate);		
		 if (idValidate2 == null) {
	            return new ResponseEntity<>("ok", HttpStatus.OK);
	        }
		
		
		return new ResponseEntity<>("duplicated", HttpStatus.NOT_FOUND);
	}

}
