package com.spring.myapp.member.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.ResMember;
import com.spring.myapp.member.service.MemberService;

import oracle.jdbc.proxy.annotation.Post;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	
	@Autowired
	MemberService MemberService;

	@RequestMapping(value = "/login" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@Override
	public ResponseEntity<String> login(@RequestBody LoginForm loginForm, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ResMember loginmember = MemberService.login(loginForm);
		
		if (loginmember == null) {
            return new ResponseEntity<>("�α��� ����", HttpStatus.NOT_FOUND);
        }
		
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", loginmember);
		
		return new ResponseEntity<>("�α��� ����", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/logout" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@Override
	public ResponseEntity<String> logout(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession(false);	
		 if (session != null) {
	            session.invalidate();
	        }
		return new ResponseEntity<>("�α׾ƿ� ����", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/assign" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@Override
	public ResponseEntity<String> save(@RequestBody Member member, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		member.setUseraccount(member.getUseraccount().toLowerCase());
		
		if (member.getUseraccount().equals("guest")||member.getUseraccount().equals("GUEST")) {
			return new ResponseEntity<>("�������ʴ� ���̵� �Դϴ�.", HttpStatus.NOT_FOUND);
//			return new ResponseEntity<>("bad", HttpStatus.FAILED_DEPENDENCY);
		}
		
		int vo = MemberService.addMember(member);
		
		 if (vo!=1) {
	            return new ResponseEntity<>("ȸ������ ����", HttpStatus.NOT_FOUND);
	        }
		
		
		return new ResponseEntity<>("ȸ������ ����", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@Override
	public ResponseEntity<String> edit(@RequestBody Member member, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int vo = MemberService.updateMember(member);
		
		 if (vo!=1) {
	            return new ResponseEntity<>("��������", HttpStatus.NOT_FOUND);
	        }
		
		
		return new ResponseEntity<>("�����Ϸ�", HttpStatus.OK);
	}
	
	@PostMapping("/delete")
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
	@RequestMapping(value = "/useraccount" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<String> idValidate(@RequestBody Member useraccount, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		 Optional<Member> member =  MemberService.Validate(useraccount);
		 if (member.isEmpty()) {
	            return new ResponseEntity<>("�ߺ������ʴ� ���̵� �Դϴ�.", HttpStatus.OK);
	        }
		
		
		return new ResponseEntity<>("�ߺ� �Ǿ����ϴ�.", HttpStatus.NOT_FOUND);
	}

}
