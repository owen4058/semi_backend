package com.spring.myapp.member.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.idValidate;

public interface MemberRepository {
	public List<Member> selectAllMemberList() throws DataAccessException;
	 public int insertMember(Member member) throws DataAccessException ;
	 public int deleteMember(String id) throws DataAccessException;
	 public LoginForm loginById(LoginForm loginForm) throws DataAccessException;
	public int updateMember(Member member) throws DataAccessException;
	public idValidate validate(idValidate idValidate) throws DataAccessException;
}
