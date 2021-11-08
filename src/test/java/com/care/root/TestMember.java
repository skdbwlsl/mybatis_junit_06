package com.care.root;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@RunWith(SpringRunner.class) //test동작 시킬 때 무조건 사용
@ContextConfiguration(locations = {
		"classpath:TestMember.xml",  // main/resources을 의미
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"}) //그냥 파일 경로
public class TestMember {
	@Autowired MemberController mc;
	@Autowired MemberService ms;
	@Autowired MemberDAO dao;
	
	@Test
	public void testMc() {
		//System.out.println("mc : " + mc);
		assertNotNull(mc); //null이 아니면 성공
	}
	@Test
	public void testMs() {
		//System.out.println("mc : " + mc);
		assertNotNull(ms); //null이 아니면 성공
	}
	@Test
	public void testDao() {
		assertNotNull(dao); 
}
	@Test
	public void testDaoIns() {//dao에 있는 insert 테스트
		MemberDTO dto = new MemberDTO();
		dto.setId(111); dto.setName("홍길동");
		dao.insertMember(dto);
	}
	@Test
	public void testServiceIns() {
		MemberDTO dto = new MemberDTO();
		dto.setId(222); dto.setName("고길동");
		ms.insertMember(dto);
}
	@Test
	public void testDaoMemberView() { //select 쿼리문 테스트
		dao.memberView();
}
}