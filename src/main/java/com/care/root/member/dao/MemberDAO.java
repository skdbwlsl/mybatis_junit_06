package com.care.root.member.dao;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberDAO {
	public void insertMember(MemberDTO dto); 
	public ArrayList<MemberDTO> memberView(); //리턴값은 많은 사용자 정보가 있을테니 어레이 리스트로 돌려준다

}
