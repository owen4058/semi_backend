package com.spring.myapp.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.ResMember;
import com.spring.myapp.member.repository.MemberRepository;



@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberRepository.selectAllMemberList();
		return membersList;
	}

	@Override
	public int addMember(Member member) throws DataAccessException {
		return memberRepository.insertMember(member);
	}
	
	
	@Override
	public int updateMember(Member member) throws DataAccessException {
		return memberRepository.updateMember(member);
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberRepository.deleteMember(id);
	}
	
	@Override
	public ResMember login(LoginForm loginForm) throws Exception{
		return memberRepository.loginById(loginForm).filter(m->m.getPassword().equals(loginForm.getPassword())).orElse(null);
	}
	@Override
	public Optional<Member> Validate(Member useraccount) throws Exception{
		return memberRepository.validate(useraccount);
	}

}
