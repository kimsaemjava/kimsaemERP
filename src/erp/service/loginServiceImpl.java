package erp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dept.dao.deptDAO;
import dept.dao.deptDAOImpl;
import dept.dto.deptDTO;
import erp.dao.loginDAO;
import erp.dao.loginDAOImpl;
import erp.dto.loginDTO;

import static util.DBUtil.*;

public class loginServiceImpl implements loginService{

	@Override
	public loginDTO login(String id, String pass) {
		loginDTO user = null;
		loginDAO dao = new loginDAOImpl();
		Connection con =null;
		try{
			con =DBconnect();
			user =dao.login(id, pass, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return user;
	}

	@Override
	public ArrayList<loginDTO> empList() {
		loginDAO dao = new loginDAOImpl();
		ArrayList<loginDTO> getEmpList =null;
		Connection con = null;
		try {
			con = DBconnect();
			getEmpList =dao.empList(con);
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			close(con);
		}
		return getEmpList;
	}

	@Override
	public ArrayList<loginDTO> empinfo(String name) {
		loginDAO dao = new loginDAOImpl();
		ArrayList<loginDTO> getEmpList =null;
		Connection con = null;
		try {
			con = DBconnect();
			getEmpList =dao.empinfo(name, con);
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			close(con);
		}
		return getEmpList;
	}


}
