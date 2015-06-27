package com.hong.springboot.modules.member;

import java.util.List;

import com.hong.springboot.domains.Member;

public interface MemberRepositoryCustom {
	
	public List<Member> getListByHibernate();

}
