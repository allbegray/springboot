package com.hong.springboot.modules.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hong.springboot.domains.Member;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Transactional(readOnly = true)
	public List<Member> getListByHibernate() {
		return memberRepository.getListByHibernate();
	}

	@Transactional
	public Member add(Member member) {
		return memberRepository.save(member);
	}

	@Transactional(readOnly = true)
	public List<Member> getList() {
		return (List<Member>) memberRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Member getById(Long id) {
		return memberRepository.findOne(id);
	}

}
