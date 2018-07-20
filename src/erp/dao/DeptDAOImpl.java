package erp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static query.EmpQuery.*;

import erp.dto.DeptDTO;

public class DeptDAOImpl implements DeptDAO {

	@Override
	public ArrayList<DeptDTO> getDeptName(Connection con) throws SQLException {
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		DeptDTO dto = null;
		PreparedStatement ptmt = con.prepareStatement(DEPTNAME_SELECT);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			dto = new DeptDTO(rs.getString(1), rs.getString(2));
			list.add(dto);
		}
		return list;
	}

}
