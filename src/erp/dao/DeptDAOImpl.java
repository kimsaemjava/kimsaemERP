package erp.dao;

import static fw.DBUtil.close;
import static query.EmpQuery.EMP_LIST;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static query.EmpQuery.*;

import erp.dto.DeptDTO;

public class DeptDAOImpl implements DeptDAO{

	@Override
	public ArrayList<DeptDTO> getDeptName(Connection con) throws SQLException {

		ArrayList<DeptDTO> deptList = new ArrayList<DeptDTO>();

		DeptDTO dept = null;
		
		PreparedStatement ptmt = con.prepareStatement(DEPT_LIST);
		ResultSet rs = ptmt.executeQuery();
		
		while (rs.next()) {
			dept = new DeptDTO(rs.getString(1), rs.getString(2));
			deptList.add(dept);
		}

		close(rs);
		close(ptmt);
		return deptList;
	}

}
