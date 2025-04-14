package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.MemberDTO;

//** DAO (Data Access Object)
//=> SQL 구문처리
//=> CRUD
//	 Create(insert), Read(selectList, selectOne), Update(update), Delete(delete)

public class MemberDAO {
	//** SQL 구문처리를 위한 전역변수 정의
	private static Connection cn=DBConnection.getConnection();
	private static PreparedStatement pst;
	private static ResultSet rs;
	private String sql;

	//** selectList
	public List<MemberDTO> selectList() {
		sql = "select * from member";
		List<MemberDTO> mlist = new ArrayList<>();
		try {
			pst = cn.prepareStatement(sql);
	        rs = pst.executeQuery();
			if(rs.next()) {
				do {
					MemberDTO sdto = new MemberDTO();
					sdto.setId(rs.getString(1));
					sdto.setPassword(rs.getString(2));
					sdto.setName(rs.getString(3));
					sdto.setAge(rs.getInt(4));
					sdto.setJno(rs.getInt(5));
					sdto.setInfo(rs.getString(6));
					sdto.setPoint(rs.getDouble(7));
					sdto.setBirthday(rs.getString(8));
					sdto.setRid(rs.getString(9));
					mlist.add(sdto);
				}while(rs.next());
			}else {
				System.out.println("Member List : 출력자료가 한건도 없습니다. ");
				mlist=null;
			}
			return mlist;
		}catch(Exception e) {
			System.out.println("MemberList Exception => "+ e.toString());
			mlist=null;
		}
		return null;
	}

	//** selectOne
	public MemberDTO selectOne(String id) {
		sql="select * from member where id=?";
		MemberDTO mdto = new MemberDTO();
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				mdto.setId(rs.getString(1));
				mdto.setPassword(rs.getString(2));
				mdto.setName(rs.getString(3));
				mdto.setAge(rs.getInt(4));
				mdto.setJno(rs.getInt(5));
				mdto.setInfo(rs.getString(6));
				mdto.setPoint(rs.getInt(7));
				mdto.setBirthday(rs.getString(8));
				mdto.setRid(rs.getString(9));
			}else {
				mdto=null;
			}
		}catch(Exception e) {
			System.out.println("MemberList Exception => "+ e.toString());
			mdto=null;
		}
		return mdto;
	}

	//** insert
	public int insert(MemberDTO mdto) {
		sql="insert into member values(?,?,?,?,?,?,?,?,?)";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, mdto.getId());
			pst.setString(2, mdto.getPassword());
			pst.setString(3, mdto.getName());
			pst.setInt(4, mdto.getAge());
			pst.setInt(5, mdto.getJno());
			pst.setString(6, mdto.getInfo());
			pst.setDouble(7, mdto.getPoint());
			pst.setString(8, mdto.getBirthday());
			pst.setString(9, mdto.getRid());
			return pst.executeUpdate();
		}catch (Exception e) {
			System.out.println("Member insert Exception => "+ e.toString());
			return 0;
		}
	}

	//** update
	//=> SQL에서는 P.Key 수정 가능하지만, id는 수정하지않음
	//=> password는 별도로 단독 수정
	//=> 위 외에는 모두 수정 가능
	public int update(MemberDTO mdto) {
		sql="update member set name=?,age=?,jno=?,info=?,point=?,birthday=?,rid=? where id=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, mdto.getName());
			pst.setInt(2, mdto.getAge());
			pst.setInt(3, mdto.getJno());
			pst.setString(4, mdto.getInfo());
			pst.setDouble(5, mdto.getPoint());
			pst.setString(6, mdto.getBirthday());
			pst.setString(7, mdto.getRid());
			pst.setString(8, mdto.getId());

			return pst.executeUpdate();
		}catch (Exception e) {
			System.out.println("Member update Exception => "+ e.toString());
			return 0;
		}
	}

	//** delete
	public int delete(String id) {
		sql="delete from member where id=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, id);

			return pst.executeUpdate();
		}catch (Exception e) {
			System.out.println("Member delete Exception => "+ e.toString());
			return 0;
		}
	}




}
