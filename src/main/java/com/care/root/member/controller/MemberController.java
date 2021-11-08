package com.care.root.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms;
	@GetMapping("index")
	public String index() {
		return "member/index";
	}
	@GetMapping("insertview")//데이터보기
	public String insertView() {
		return "member/insertview";
	}
	@PostMapping("insert")//데이터 추가하기
	public String inser(MemberDTO dto) {
		ms.insertMember(dto);
		return "redirect:index";
	}
	@GetMapping("memberview") //데이터 가져오기
	public String memberview(Model model) {
		ms.memberView(model);
		return "member/memberview";
	}

}
