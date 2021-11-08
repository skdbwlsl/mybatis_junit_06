package com.care.root;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.care.root.member.controller.MemberController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;



@RunWith(SpringRunner.class)
@ContextConfiguration(locations={
		"classpath:TestMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class TestMock {
	@Autowired MemberController mc; //컨트롤 객체
	MockMvc mock;                   //mock객체 : 컨트롤 정보 넣고 목 정보를 이용해 경로 넣기
	
	@Before  //먼저 처리해라
	public void setUp() {
		System.out.println("test 실행전-----");
		mock = MockMvcBuilders.standaloneSetup(mc).build();
	}
	@Test
	public void testIndex() throws Exception{
		System.out.println("----- test코드 실행");
		mock.perform(get("/index")) // 경로 앞에 무조건 / 들어와야 함
		.andDo(print())//연결된 상태
		.andExpect(status().isOk())//상태가 200이면 성공으로 처리
		.andExpect(forwardedUrl("member/index"));//리턴 경로가 member/index가 맞는지
	}
	@Test
	@Transactional(transactionManager = "txMgr") //롤백기능으로 했던 결과 없는 걸로 되돌리기
	public void testInsert() throws Exception{
		mock.perform(post("/insert").param("id", "1234").param("name","111이"))//param으로 값 넘기기
		.andDo(print())
		.andExpect(status().is3xxRedirection());//redirect면 성공
	}
	@Test
	public void testMemberview() throws Exception {
		mock.perform(get("/memberview")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("member/memberview"))
		.andExpect(model().attributeExists("list"));
	}
}
