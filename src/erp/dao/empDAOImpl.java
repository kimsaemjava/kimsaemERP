package erp.dao;
import static fw.DBUtil.*;
import static query.EmpQuery.DELETE_EMP;
import static query.EmpQuery.INSERT_REG;
import static query.EmpQuery.SELECT_DEPTNO;
import static query.EmpQuery.SELECT_EMP;
import static query.EmpQuery.SELECT_LOGIN;
import static query.EmpQuery.UPDATE_EMP;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.empDTO;
public class empDAOImpl implements empDAO {

	@Override
	public int insert(String deptno, String name, String id, String pass, String addr, int point, String grade,
			Connection con) throws SQLException {
		int result=0;
		PreparedStatement ptmt = con.prepareStatement(INSERT_REG);
		//con = g;
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ptmt.setString(3, name);
		ptmt.setString(4, addr);
		ptmt.setString(5, grade);
		ptmt.setInt(6, point);
		ptmt.setString(7, deptno);
		result=ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

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
	public empDTO read(String id, Connection con) throws SQLException {
		empDTO result=null;
		PreparedStatement ptmt = con.prepareStatement(SELECT_DEPTNO);
//		con = DBconnect();
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()){
			result= new empDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8));
		}
		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<empDTO> getemplist(String col, String value,String pass, Connection con) throws SQLException {
		ArrayList<empDTO> joininfo = new ArrayList<empDTO>();
		empDTO e =null;
//		String sql2= "select * from kitriemp where"+col+"=?and pass=?";
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

}
