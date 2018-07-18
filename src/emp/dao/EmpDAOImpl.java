package emp.dao;

import static db.util.DBUtil.close;
import static db.util.EmpQuery.EMP_DELETE;
import static db.util.EmpQuery.EMP_INSERT;
import static db.util.EmpQuery.EMP_LIST;
import static db.util.EmpQuery.EMP_READ;
import static db.util.EmpQuery.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emp.dto.EmpDTO;


public class EmpDAOImpl implements EmpDAO{

	@Override
	public int insert(EmpDTO user, Connection con) throws SQLException {
		int result = 0;
		
		PreparedStatement ptmt = con.prepareStatement(EMP_INSERT);
		
		ptmt.setString(1, user.getEmp_id());
		ptmt.setString(2, user.getPass());
		ptmt.setString(3, user.getName());
		ptmt.setString(4, user.getAddr());
		ptmt.setString(5, user.getGrade());
		ptmt.setInt(6, user.getPoint());
		ptmt.setString(7, user.getDeptNo());
		
		result = ptmt.executeUpdate();
		//
		close(ptmt);
		
		return result;
	}

	//2.
	@Override
	public ArrayList<EmpDTO> getMemberList(Connection con) throws SQLException {
		
		//user 전체 목록을 담을 자료구조
		ArrayList<EmpDTO> userlist = new ArrayList<EmpDTO>(); 
		//하나의 user를 담을 객체를 정의 - 레코드가 조회되면 레코드 하나의 값을 셋팅할 것이므로
		//						while문안에서 생성해야 한다.
		EmpDTO user = null;
		System.out.println("dao 요청");
	
		PreparedStatement ptmt = con.prepareStatement(EMP_LIST);
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()){
			//레코드 하나의 값을 dto객체로 변환하는 작업
			user = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), 
					rs.getString(6), rs.getInt(7), rs.getString(8));
			
			/*user = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
					rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
			*///변환이 완료되면 ArrayList에 축
			userlist.add(user);
		}
		System.out.println("ArrayList 개수 : " + userlist.size());
		System.out.println(userlist);
		
		return userlist;
	}

	@Override
	public int delete(String id, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(EMP_DELETE);
		System.out.println(id);
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
			user = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getDate(5), rs.getString(1), rs.getInt(7), rs.getString(8));
		}
		close(ptmt);
		
		return user;
	}

	@Override
	public ArrayList<EmpDTO> Search(String column, String search, String pass, Connection con) throws SQLException {
	
		//user 전체 목록을 담을 자료구조
		System.out.println(column+","+search); //중간에 값이 잘 넘어오는지 확인
		
		ArrayList<EmpDTO> userlist = new ArrayList<EmpDTO>();
		EmpDTO user = null;
		
		//query에서 아닌 여기서 sql문 ㄱㄱ . ? like ? 가 안되니 아래와 같이 하기도 한다
		/*String sql = 
				"select * from kitriemp where "+column
				+"=? and pass = ?";*/
		
		/*String sql =
				"select * from kitriemp where id=? and pass=?";*/
		/*String sql =
				"select * from kitriemp where "+column+"='"
				+search +"' and pass='" + pass +"'";*/
		
		String sql = "";
		if(column.equals("name")){
			sql = EMP_SEARCH1;
		}else if(column.equals("addr")){
			sql = EMP_SEARCH2;
		}else{
			sql = EMP_SEARCH3;
		}
		
		PreparedStatement ptmt = con.prepareStatement(sql);
		
		//
		//Statement ptmt = con.createStatement();
		//나온 페이지에 아이디' -- sql인젝션(로그인 가능), --은 뒤에것을 주석으로 만들겠다는 뜻.
		//id = '' or '1' = '1' --
		//입력값을 검증하는 작업이 가장 중요하다.
		
		
		//ptmt.setString(1, column);
		ptmt.setString(1, "%"+search+"%");
		
		//
		//ptmt.setString(1, search);
		//ptmt.setString(2, pass);
		
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()){
			user = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8));
			//
			userlist.add(user);
		}
		close(ptmt);
		System.out.println("userlist 갯수=" + userlist.size());
		System.out.println("userlist =" + userlist);
		System.out.println("user =" + user);
		
		return userlist;
	}

	@Override
	public int update(EmpDTO data, Connection con) throws SQLException {
		int result = 0;
		
		PreparedStatement ptmt = con.prepareStatement(EMP_UPDATE);
		
		ptmt.setString(1, data.getAddr());
		ptmt.setString(2, data.getGrade());
		ptmt.setInt(3, data.getPoint());
		ptmt.setString(4, data.getEmp_id());
		
		result = ptmt.executeUpdate();
		//
		close(ptmt);
		return result;
	}

	@Override
	public EmpDTO login(String id, String pass, Connection con) throws SQLException {
		EmpDTO user = null;
		PreparedStatement ptmt = con.prepareStatement(EMP_LOGIN);
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ResultSet rs = ptmt.executeQuery();
		
		if(rs.next()){
			user = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getDate(5), rs.getString(1), rs.getInt(7), rs.getString(8));
		}
		close(ptmt);
		
		return user;
	}
}
