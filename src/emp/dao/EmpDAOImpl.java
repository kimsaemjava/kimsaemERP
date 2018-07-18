package emp.dao;
import static fw.DBUtil.*;
import static query.EmpQuery.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.dto.EmpDTO;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public int insert(EmpDTO user, Connection con) 
									throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(EMP_INSERT);
		ptmt.setString(1, user.getId());
		ptmt.setString(2, user.getPass());
		ptmt.setString(3, user.getName());
		ptmt.setString(4, user.getAddr());
		ptmt.setString(5, user.getGrade());
		ptmt.setInt(6, user.getPoint());
		ptmt.setString(7, user.getDeptno());
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<EmpDTO> getMemberList(Connection con) 
									throws SQLException {
		//user 전체 목록을 담을 자료구조 
		ArrayList<EmpDTO> userlist = new ArrayList<EmpDTO>();
		//하나의 user를 담을 객체를 정의 - 레코드가 조회되면 레코드 하나의 값을 셋팅할 것이므로
		//                     while문안에서 생성해야 한다.
		EmpDTO user = null;
		System.out.println("dao요청");
		PreparedStatement ptmt = con.prepareStatement(EMP_LIST);
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()){
			//레코드 하나의 값을 dto객체로 변환하는 작업
			user = new EmpDTO(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4),
					rs.getDate(5), rs.getString(6),
					rs.getInt(7), rs.getString(8));
			//변환이 완료되면 ArrayList에 추가
			userlist.add(user);		
		}
		System.out.println("ArraList의 갯수=>"+userlist.size());
		System.out.println(userlist);
		return userlist;
	}

	@Override
	public int delete(String id, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(EMP_DELETE);
		ptmt.setString(1, id);
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public EmpDTO read(String id, Connection con) throws SQLException {
		
		EmpDTO user = null;
		PreparedStatement ptmt = con.prepareStatement(EMP_READ);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()){
			System.out.println("데이터있다~~~~~");
			user = new EmpDTO(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4),
					rs.getDate(5), rs.getString(6),
					rs.getInt(7), rs.getString(8));
		}
		close(ptmt);
		return user;
	}

	@Override
	public ArrayList<EmpDTO> search(String column,
			String search,String pass, Connection con) throws SQLException {
		//user 전체 목록을 담을 자료구조 
		System.out.println(column+","+search);
		ArrayList<EmpDTO> userlist = new ArrayList<EmpDTO>();
		EmpDTO user = null;
		/*String sql = "select * from kitriemp where "
					+column+"= ?";*/
		String sql = "";
		if(column.equals("name")){
			sql = EMP_SEARCH1;
		}else if(column.equals("addr")){
			sql = EMP_SEARCH2;
		}else{
			sql = EMP_SEARCH3;
		}
		PreparedStatement ptmt = con.prepareStatement(sql);
		ptmt.setString(1, "%"+search+"%");
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()){
			user = new EmpDTO(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4),
					rs.getDate(5), rs.getString(6),
					rs.getInt(7), rs.getString(8));
			userlist.add(user);		
		}
		System.out.println("ArraList의 갯수=>"+userlist.size());
		System.out.println(userlist);
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
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public EmpDTO login(String id, String pass, Connection con) throws SQLException {
		EmpDTO user = null;
		PreparedStatement ptmt = con.prepareStatement(LOGIN);
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()){
			System.out.println("데이터있다~~~~~");
			user = new EmpDTO(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4),
					rs.getDate(5), rs.getString(6),
					rs.getInt(7), rs.getString(8));
		}
		close(ptmt);
		return user;
		
	}

}














