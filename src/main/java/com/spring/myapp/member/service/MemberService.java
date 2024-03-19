package com.spring.myapp.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.ResMember;

public interface MemberService {
	 public List listMembers() throws DataAccessException;
	 public int addMember(Member memberVO) throws DataAccessException;
	 public int removeMember(String id) throws DataAccessException;
	 public ResMember login(LoginForm loginForm) throws Exception;
	 public int updateMember(Member member) throws DataAccessException;
	 public Optional<Member> Validate(Member idValidate) throws Exception;
}
