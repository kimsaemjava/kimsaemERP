package erp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.loginDTO;

public interface loginDAO {
	loginDTO login(String id,String pass, Connection con)throws SQLException;
	ArrayList<loginDTO> empList(Connection con) throws SQLException;
	ArrayList<loginDTO> empinfo(String name,Connection con) throws SQLException;
	
}
