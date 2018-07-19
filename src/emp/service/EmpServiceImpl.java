package emp.service;

import static fw.DBUtil.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.dao.EmpDAO;
import emp.dao.EmpDAOImpl;
import emp.dao.LoginDAO;
import emp.dao.LoginDAOImpl;
import emp.dto.EmpDTO;
import emp.dto.LoginDTO;

public class EmpServiceImpl implements EmpService{

	@Override
	public int insert(EmpDTO emp) {
		int result = 0;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;
		try {
			con = getConnect();
			result = dao.insert(emp,con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;

	}

	@Override
	public ArrayList<EmpDTO> getMemberList() {
		ArrayList<EmpDTO> empList = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;

		try {
			con = getConnect();
			empList = dao.getMemberList(con);
			//System.out.println("service »£√‚");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return empList;
	}

	@Override
	public int delete(String id) {
		int result = 0;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;
		try {
			con = getConnect();
			result = dao.delete(id,con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;

	}

	@Override
	public EmpDTO read(String id) {
		
		EmpDTO emp = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;

		try {
			con = getConnect();
			emp = dao.read(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return emp;
	}

	@Override
	public ArrayList<EmpDTO> search(String column, String search) {
		
		ArrayList<EmpDTO> empList = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;

		try {
			con = getConnect();
			empList = dao.search(column, search, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return empList;
	}

	@Override
	public int update(EmpDTO emp) {
		
		int result = 0;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;
		try {
			con = getConnect();
			result = dao.update(emp,con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}

	@Override
	public LoginDTO login(String id, String pass) {
		
		LoginDTO emp = null;
		LoginDAO dao = new LoginDAOImpl();
		Connection con = null;

		try {
			con = getConnect();
			emp = dao.login(id, pass, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return emp;
	}

}
