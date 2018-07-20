package erp.dao;
import static fw.DBUtil.*;
import static query.EmpQuery.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.DeptDTO;
import erp.dto.MemberDTO;
import erp.dto.empDTO;
public class empDAOImpl implements empDAO {

	@Override
	public ArrayList<empDTO> search(Connection con) throws SQLException {
		PreparedStatement ptmt  = con.prepareStatement(SELECT_EMP);
		//user 전체 목록을 담을 자료구조
		ArrayList<empDTO> joininfo = new ArrayList<empDTO>();
		//하나의 user를 담을 객체를 정의 - 레코드가 조회되면 레코드 하나의 값을 셋팅할 것이므로
		//							while문안에서 생성해야 한다.
		empDTO e =null;
		System.out.println("회원목록 조회");
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			e= new empDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8));
			System.out.println("GetID"+rs.getString(1));
			joininfo.add(e);
		}
		close(rs);
		close(con);
		return joininfo;
	}

	@Override
	public int delete(String id, Connection con) throws SQLException {
		int result=0;
		PreparedStatement ptmt = con.prepareStatement(DELETE_EMP);
	//	con = DBconnect();
		ptmt.setString(1, id);
		result=ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public MemberDTO read(String id, Connection con) throws SQLException {
		MemberDTO dto=null;
		System.out.println("readDAO"+id);
		PreparedStatement ptmt = con.prepareStatement(EMPLIST_READ);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()){
			dto= new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
					rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
					rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
					rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
					rs.getString(20), rs.getString(21), rs.getString(22));
		}
		close(ptmt);
		return dto;
	}

	@Override
	public ArrayList<empDTO> getemplist(String col, String value,String pass, Connection con) throws SQLException {
		ArrayList<empDTO> joininfo = new ArrayList<empDTO>();
		empDTO e =null;
		String sql ="select * from kitriemp where $tableName=? ";
		String query= sql.replace("$tableName", col);
		PreparedStatement ptmt  = con.prepareStatement(query);
		ptmt.setString(1,value);
//		ptmt.setString(2,pass);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			e= new empDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8));
			joininfo.add(e);
			System.out.println("반응");
			
		}
		close(rs);
		close(con);
		return joininfo;
	}

	@Override
	public int update(empDTO user, Connection con) throws SQLException {
		int result=0;
		PreparedStatement ptmt = con.prepareStatement(UPDATE_EMP);
		System.out.println("update DAO");
		ptmt.setString(1, user.getAddr());
		ptmt.setString(2, user.getGrade());
		ptmt.setInt(3, user.getPoint());
		ptmt.setString(4, user.getId());
		result= ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public empDTO login(String id, String pass, Connection con) throws SQLException {
		empDTO result=null;
		PreparedStatement ptmt = con.prepareStatement(SELECT_LOGIN);
//		con = DBconnect();
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()){
			result= new empDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8));
		}
		close(ptmt);
		return result;
	}

	@Override
	public int insert(MemberDTO dto, Connection con) throws SQLException {
		int result=0;
		System.out.println("dao dto값:"+dto);
		PreparedStatement ptmt = con.prepareStatement(INSERT_MEMBER);
		ptmt.setString(1, dto.getId());
		ptmt.setString(2, dto.getPass());
		ptmt.setString(3, dto.getName());
		ptmt.setString(4, dto.getSsn());
		ptmt.setString(5, dto.getBirthday());
		ptmt.setString(6, dto.getMarry());
		ptmt.setString(7, dto.getDeptno());
		ptmt.setString(8, dto.getZipcode());
		ptmt.setString(9, dto.getAddr());
		ptmt.setString(10, dto.getPhonehome());
		ptmt.setString(11, dto.getPhoneco());
		ptmt.setString(12, dto.getPhonecell());
		ptmt.setString(13, dto.getEmail());
		ptmt.setString(14, dto.getProfile_photo());
		
		result=ptmt.executeUpdate();
		System.out.println(result+"-result값");
		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<DeptDTO> emplist(Connection con) throws SQLException {
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		DeptDTO dto = null;
		System.out.println("emplist daoimpl");
		PreparedStatement ptmt = con.prepareStatement(EMPLIST_SELECT);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			dto = new DeptDTO(rs.getString(1), rs.getString(2), 
					rs.getString(4), rs.getString(5), rs.getString(3));
			list.add(dto);
			System.out.println(dto);
		}
		return list;
	}

}
