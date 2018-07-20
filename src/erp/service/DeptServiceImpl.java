package erp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dao.DeptDAO;
import erp.dao.DeptDAOImpl;
import erp.dto.DeptDTO;
import static fw.DBUtil.*;

public class DeptServiceImpl implements DeptService {

	@Override
	public ArrayList<DeptDTO> getDeptName() {
		ArrayList<DeptDTO> list = null;
		Connection con = null;
		con = getConnect();
		DeptDAO dao = new DeptDAOImpl();
		try {
			list = dao.getDeptName(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return list;
	}
	
	

}
