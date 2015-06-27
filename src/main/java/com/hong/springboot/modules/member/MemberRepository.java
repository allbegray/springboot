package com.hong.springboot.modules.member;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hong.springboot.domains.Member;

@Repository
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {

}
