package com.hong.springboot.modules.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hong.springboot.domains.Member;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(method = RequestMethod.POST)
	public Member add(Member member) {
		return memberService.add(member);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Member get(@PathVariable Long id) {
		return memberService.getById(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Member> list(Model model) {
		return memberService.getList();
	}

}
