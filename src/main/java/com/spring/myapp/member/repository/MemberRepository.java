package com.spring.myapp.member.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.ResMember;

public interface MemberRepository {
	public List<Member> selectAllMemberList() throws DataAccessException;
	
	 public int insertMember(Member member) throws DataAccessException ;
	 
	 public int deleteMember(String id) throws DataAccessException;
	 
	 public Optional<ResMember> loginById(LoginForm loginForm) throws DataAccessException;
	 
	public int updateMember(Member member) throws DataAccessException;
	
	public Optional<Member> validate(Member idValidate) throws DataAccessException;
}
