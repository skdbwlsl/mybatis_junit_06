package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;

@Service
public class MemberServiceimpl implements MemberService{
	@Autowired MemberDAO mapper;
	public void insertMember(MemberDTO dto) {
		mapper.insertMember(dto);
	}
	public void memberView(Model model) { //오버라이딩
		model.addAttribute("list",mapper.memberView());
	}
}
