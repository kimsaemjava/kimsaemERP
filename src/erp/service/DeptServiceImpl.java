package erp.service;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dao.DeptDAO;
import erp.dao.DeptDAOImpl;
import erp.dto.DeptDTO;

public class DeptServiceImpl implements DeptService {

	@Override
	public ArrayList<DeptDTO> getDeptName() {
		ArrayList<DeptDTO> deptnameList = null;
		DeptDAO dao  = new DeptDAOImpl();
		Connection con = null;
		try{
			System.out.println("서비스 호출");
			con = getConnect();
			deptnameList = dao.getDeptName(con);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(con);
		}		
		return deptnameList;
	}

}
