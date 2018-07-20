package erp.service;

import static fw.DBUtil.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dao.EmpDAO;
import erp.dao.EmpDAOImpl;
import erp.dto.EmpDTO;
import erp.dto.LoginDTO;
import erp.dto.MemberDTO;

public class EmpServiceImpl implements EmpService{

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
		
		LoginDTO user = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;

		try {
			con = getConnect();
			user = dao.login(id, pass, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return user;
	}

	@Override
	public int insert(MemberDTO emp) {
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
	public ArrayList<LoginDTO> getMemberList() {
		ArrayList<LoginDTO> empList = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;

		try {
			con = getConnect();
			empList = dao.getMemberList(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return empList;
	}

}
