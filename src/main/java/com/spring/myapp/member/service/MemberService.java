package com.spring.myapp.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.idValidate;

public interface MemberService {
	 public List listMembers() throws DataAccessException;
	 public int addMember(Member memberVO) throws DataAccessException;
	 public int removeMember(String id) throws DataAccessException;
	 public Member login(LoginForm loginForm) throws Exception;
	int updateMember(Member member) throws DataAccessException;
	idValidate Validate(idValidate idValidate) throws Exception;
}
