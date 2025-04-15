package service;

import java.util.List;

import domain.MemberDTO;
import model.MemberDAO;

public class MemberService {
	//** 전역변수 정의
	MemberDAO dao = new MemberDAO();

	//** selectList
	public List<MemberDTO> selectList(){
		return dao.selectList();
	}

	//** selectOne
	public MemberDTO selectOne(String id) {
		return dao.selectOne(id);
	}

	//** insert
	public int insert(MemberDTO mdto) {
		return dao.insert(mdto);
	}

	//** update
	public int update(MemberDTO mdto) {
		return dao.update(mdto);
	}

	//** delete
	public int delete(String id) {
		return dao.delete(id);
	}
}
