package erp.dao;

import static fw.DBUtil.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.EmpDTO;
import erp.dto.LoginDTO;
import erp.dto.MemberDTO;

import static query.EmpQuery.*;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public int delete(String id, Connection con) throws SQLException {

		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(DELETE_EMP);

		ptmt.setString(1, id);

		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public EmpDTO read(String id, Connection con) throws SQLException {
		
		EmpDTO emp = new EmpDTO();
		PreparedStatement ptmt = con.prepareStatement(SELECT_EMP);
		
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();

/*		while (rs.next()) {
			emp = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
														rs.getDate(5),rs.getString(6), rs.getInt(7), rs.getString(8));
		}
		//값이 하나니까 if문도 ok
		*/
		
		if (rs.next()) {
			System.out.println("데이터 있음");
			emp = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
														rs.getDate(5),rs.getString(6), rs.getInt(7), rs.getString(8));
		}
		close(rs);
		close(ptmt);
		
		return emp;
	}

	@Override
	public ArrayList<EmpDTO> search(String column, String search, Connection con) throws SQLException {
		System.out.println(column+","+search);
		
		ArrayList<EmpDTO> empList = new ArrayList<EmpDTO>();
		EmpDTO emp = null;
		
		//String sql = "select * from kitriemp where " + column + " like ?";
		//String sql = "select * from kitriemp where " + column + " =? and pass =?";
/*		String sql = "select * from kitriemp where "+column+"= '"+search+"' and pass='"+pass+"'"; //로그인 sql문
		Statement ptmt = con.createStatement();*/
		
		String sql ="";
		if(column.equals("name")){
			sql = SEARCH_EMP1;
		}else if(column.equals("id")){
			sql= SEARCH_EMP2;
		}else{
			sql= SEARCH_EMP3;
		}
		
		PreparedStatement ptmt = con.prepareStatement(sql);
		ptmt.setString(1, "%"+search+"%");
		
		ResultSet rs = ptmt.executeQuery();

		while (rs.next()) {
			emp = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
														rs.getDate(5),rs.getString(6), rs.getInt(7), rs.getString(8));
			empList.add(emp);
		}
		
		close(rs);
		close(ptmt);
		return empList;
	}

	@Override
	public int update(EmpDTO emp, Connection con) throws SQLException {
		
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(UPDATE_EMP);

		ptmt.setString(1, emp.getAddr());
		ptmt.setInt(2, emp.getPoint());
		ptmt.setString(3, emp.getGrade());
		ptmt.setString(4, emp.getId());

		result = ptmt.executeUpdate();
		close(ptmt);

		return result;
	}

	@Override
	public LoginDTO login(String id, String pass, Connection con) throws SQLException {

		LoginDTO user = null;
		PreparedStatement ptmt = con.prepareStatement(LOGIN);
		
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ResultSet rs = ptmt.executeQuery();

		if (rs.next()) {
			user = new LoginDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), 
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 
					rs.getDate(11), rs.getDate(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), 
					rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22),
					rs.getString(23), rs.getString(24), rs.getString(25));
		}
		close(rs);
		close(ptmt);
		
		return user;
		
	}

	@Override
	public int insert(MemberDTO user, Connection con) throws SQLException {
		int result = 0;
		System.out.println("dao→ "+user);

		String gender = "1"; //여자
		String state = user.getSsn().substring(6,8);
		if(state.equals("1") |state.equals("3")){
			gender = "0"; //남자
		}
		PreparedStatement ptmt = con.prepareStatement(INSERT_EMP);
		ptmt.setString(1, user.getId());
		ptmt.setString(2, user.getPass());
		ptmt.setString(3, user.getName());
		ptmt.setString(4, user.getSsn());
		ptmt.setDate(5, user.getBirthday());
		ptmt.setString(6, user.getMarry());
		ptmt.setString(7, gender);
		ptmt.setString(8, user.getDeptno());
		ptmt.setString(9, user.getZipcode());
		ptmt.setString(10, user.getAddr());
		ptmt.setString(11, user.getDetailaddr());
		ptmt.setString(12, user.getPhonehome());
		ptmt.setString(13, user.getPhoneco());
		ptmt.setString(14, user.getPhonecell());
		ptmt.setString(15, user.getEmail());

		result = ptmt.executeUpdate();
		close(ptmt);

		return result;

	}

	@Override
	public ArrayList<LoginDTO> getMemberList(Connection con) throws SQLException {
		
		ArrayList<LoginDTO> empList = new ArrayList<LoginDTO>();
		LoginDTO emp = null;
		
		//System.out.println("dao요청");
		
		PreparedStatement ptmt = con.prepareStatement(SELECT_EMP_LIST);
		ResultSet rs = ptmt.executeQuery();

		while (rs.next()) {
			emp = new LoginDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), 
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 
					rs.getDate(11), rs.getDate(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), 
					rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22),
					rs.getString(23), rs.getString(24), rs.getString(25));
			empList.add(emp);
		}
		
		close(rs);
		close(ptmt);
		return empList;
	}
}
