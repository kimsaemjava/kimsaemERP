package erp.dao;

import static fw.DBUtil.close;
import static query.EmpQuery.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import erp.dto.EmpDTO;
import erp.dto.LoginDTO;
import erp.dto.MemberDTO;

public class EmpDAOImpl implements EmpDAO {
	@Override
	public int insert(MemberDTO user, Connection con) throws SQLException { // 사원등록
		int result = 0;
		System.out.println("dao"+user);
		
		// gender는 0이 남자, 1이 여자
		String gender = "1";	// 여자(default)
		String state = user.getSsn().substring(6, 8);	// 민증상의 7번째 숫자를 가져옴
		if(state.equals("1")|state.equals("3")){
			gender = "0";	// 남자
		}
		PreparedStatement ptmt = con.prepareStatement(EMP_INSERT);
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
	public ArrayList<LoginDTO> getMemberList(Connection con) throws SQLException { // 사원목록출력
		// user 전체 목록을 담을 자료구조
		ArrayList<LoginDTO> userlist = new ArrayList<LoginDTO>();
		// 하나의 user를 담을 객체를 정의 - 레코드가 조회되면 레코드 하나의 값을 세팅할 것이므로 while문 안에서 생성해야
		// 한다.
		LoginDTO user = null;
		PreparedStatement ptmt = con.prepareStatement(LIST);
		ResultSet rs = ptmt.executeQuery();
		System.out.println("dao호출");
		while (rs.next()) {
			// 레코드 하나의 값을 dto객체로 변환하는 작업
			user = new LoginDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
					rs.getDate(11), rs.getDate(12), rs.getString(13), rs.getString(14), rs.getString(15),
					rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
					rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24), rs.getString(25));
			userlist.add(user);
		}
		close(rs);
		close(ptmt);
		return userlist;
	}

	@Override
	public int delete(String id, Connection con) throws SQLException { // 사원삭제
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(EMP_DELETE);
		ptmt.setString(1, id);
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public EmpDTO read(String id, Connection con) throws SQLException { // 사원조회
		EmpDTO user = new EmpDTO();
		PreparedStatement ptmt = con.prepareStatement(EMP_READ);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		if (rs.next()) {
			user = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getString(6), rs.getInt(7), rs.getString(8));
		}
		close(ptmt);
		return user;
	}

	@Override
	public ArrayList<EmpDTO> search(String column, String search, String pass, Connection con) // 사원검색
			throws SQLException {
		ArrayList<EmpDTO> userlist = new ArrayList<EmpDTO>();
		EmpDTO user = null;
		String sql = "";

		if (column.equals("name")) {
			sql = EMP_SEARCH1;
		} else if (column.equals("addr")) {
			sql = EMP_SEARCH2;
		} else {
			sql = EMP_SEARCH3;
		}
		PreparedStatement ptmt = con.prepareStatement(sql);
		ptmt.setString(1, "%" + search + "%");
		ResultSet rs = ptmt.executeQuery();
		System.out.println("dao호출");
		while (rs.next()) {
			user = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getString(6), rs.getInt(7), rs.getString(8));
			userlist.add(user);
		}
		close(rs);
		close(ptmt);
		return userlist;
	}

	@Override
	public int update(EmpDTO user, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(EMP_UPDATE);
		ptmt.setString(1, user.getAddr());
		ptmt.setInt(2, user.getPoint());
		ptmt.setString(3, user.getGrade());
		ptmt.setString(4, user.getId());
		System.out.println("dao호출");
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
			System.out.println("dao호출");
			user = new LoginDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
					rs.getDate(11), rs.getDate(12), rs.getString(13), rs.getString(14), rs.getString(15),
					rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
					rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24), rs.getString(25));
		}
		close(ptmt);
		return user;
	}
}