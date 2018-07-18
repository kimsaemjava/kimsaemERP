package emp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.dao.EmpDAO;
import emp.dao.EmpDAOImpl;
import emp.dto.EmpDTO;

import static fw.DBUtil.*;

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
		} finally {
			close(con);
		}

		return result;
	}

	@Override
	public ArrayList<EmpDTO> getMemberList() {
		// TODO Auto-generated method stub
		ArrayList<EmpDTO> userlist = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;

		try {
			con = getConnect();
			userlist = dao.getMemberList(con);
			System.out.println("서비스 호출");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return userlist;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		int result = 0;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;

		try {
			System.out.println("서비스 호출");
			con = getConnect();
			result = dao.delete(id, con);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}

	@Override
	public EmpDTO read(String id) {
		// TODO Auto-generated method stub
		EmpDTO user = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;

		try {
			System.out.println("서비스 호출");
			con = getConnect();
			user = dao.read(id, con);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return user;
	}

	@Override
	public ArrayList<EmpDTO> search(String column, String search, String pass) {
		// TODO Auto-generated method stub

		ArrayList<EmpDTO> usersearch = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;

		try {
			System.out.println("서비스 호출");
			con = getConnect();
			usersearch = dao.search(column, search, pass, con);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return usersearch;
	}

	@Override
	public int update(EmpDTO user, String id) {
		int result = 0;
		Connection con = null;
		EmpDAO dao = new EmpDAOImpl();
		try {
			con = getConnect();
			result = dao.update(user, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}

		return result;
	}

	@Override
	public EmpDTO login(String id, String pass) {
		// TODO Auto-generated method stub
		EmpDTO login = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;

		try {
			System.out.println("서비스 호출");
			con = getConnect();
			login = dao.login( id, pass, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return login;
	}
}