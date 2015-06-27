package com.hong.springboot.modules.member;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hong.springboot.domains.Member;

public class MemberRepositoryImpl implements MemberRepositoryCustom {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getListByHibernate() {
		return sessionFactory.getCurrentSession().createCriteria(Member.class).list();
	}

}
