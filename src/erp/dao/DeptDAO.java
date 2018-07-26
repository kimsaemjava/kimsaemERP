package erp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.DeptDTO;

public interface DeptDAO {
	
	ArrayList<DeptDTO> getMemberList(Connection con) throws SQLException;
	
	ArrayList<DeptDTO> getDeptName(Connection con) throws SQLException;

}
