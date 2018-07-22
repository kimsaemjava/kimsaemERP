package erp.dao;

import static query.DeptQuery.Dept_NAME;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.DeptDTO;

public class DeptDAOImpl implements DeptDAO {

	@Override
	public ArrayList<DeptDTO> getDeptName(Connection con) throws SQLException {
		ArrayList<DeptDTO> deptlist = new ArrayList<DeptDTO>();
	
		DeptDTO dept = null;
		System.out.println("dao요청");
		PreparedStatement ptmt = con.prepareStatement(Dept_NAME);
		ResultSet rs = ptmt.executeQuery();

		while (rs.next()) {
			dept = new DeptDTO(rs.getString(1),rs.getString(2));
			// 변환이 완료되면 ArrayList에 추가
			deptlist.add(dept);
			System.out.println(dept);	
		}
		System.out.println("ArraList의 갯수=>" + deptlist.size());
		
		return deptlist;
	}

}
