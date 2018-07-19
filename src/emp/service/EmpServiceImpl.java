package emp.service;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.dao.EmpDAO;
import emp.dao.EmpDAOImpl;
import emp.dto.EmpDTO;

public class EmpServiceImpl implements EmpService {
	
	@Override
	public int insert(EmpDTO user) {
		int result = 0;
		Connection con = null;		
		EmpDAO dao = new EmpDAOImpl();	
		try {
			con = getConnect();
			result = dao.insert(user, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return result;
	}

	@Override
	public ArrayList<EmpDTO> getMemberList() {
		ArrayList<EmpDTO> userlist = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;
		try {
			System.out.println("service호출");
			con = getConnect();
			userlist = dao.getMemberList(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}		
		return userlist;
	}

	@Override
	public int delete(String id) {
		int result = 0;
		Connection con = null;		
		EmpDAO dao = new EmpDAOImpl();	
		try {
			System.out.println("service호출");
			con = getConnect();
			result = dao.delete(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return result;
	}

	@Override
	public EmpDTO read(String id) {
		EmpDTO user = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;
		try {
			System.out.println("service호출");
			con = getConnect();
			user = dao.read(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		System.out.println(id);
		System.out.println(user);
		return user;
	}

	@Override
	public ArrayList<EmpDTO> search(String column, String search, String pass) {
		ArrayList<EmpDTO> userlist = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;
		try {
			System.out.println("service호출");
			con = getConnect();
			userlist = dao.search(column, search, pass, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}		
		return userlist;
	}

	@Override
	public int update(EmpDTO user) {
		int result = 0;
		Connection con = null;		
		EmpDAO dao = new EmpDAOImpl();	
		try {
			con = getConnect();
			result = dao.update(user, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return result;
	}

	@Override
	public EmpDTO login(String id, String pass) {
		EmpDTO user = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;
		try {
			System.out.println("service호출");
			con = getConnect();
			user = dao.login(id, pass, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return user;
	}
}