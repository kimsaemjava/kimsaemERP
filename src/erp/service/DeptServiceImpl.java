package erp.service;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dao.DeptDAO;
import erp.dao.DeptDAOImpl;
import erp.dao.EmpDAO;
import erp.dao.EmpDAOImpl;
import erp.dto.DeptDTO;

public class DeptServiceImpl implements DeptService{

	@Override
	public ArrayList<DeptDTO> getDeptName() {
		ArrayList<DeptDTO> userlist = null;
		Connection con=null;
		DeptDAO dao = new DeptDAOImpl();
	
		try {
			con = getConnect();
			userlist = dao.getDeptName(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return userlist;
	}

}
