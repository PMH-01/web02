package service;

import java.util.*;

import domain.MemberDTO;
import model.MemberDAO;

public class MemberService {
	//** 전역변수 정의
	MemberDAO mdao = new MemberDAO();
	
	//** selectList
	public List<MemberDTO> selectList(){
		return mdao.selectList();
	}
	
	//** selectOne
	public MemberDTO selectOne(String id) {
		return mdao.selectOne(id);
	}
	
	//** insert
	public int insert(MemberDTO mdto) {
		return mdao.insert(mdto);
	}
	
	//** update
	public int update(MemberDTO mdto) {
		return mdao.update(mdto);
	}
	
	//** delete
	public int delete(String id) {
		return mdao.delete(id);
	}
}
