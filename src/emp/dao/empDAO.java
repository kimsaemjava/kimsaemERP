package emp.dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.dto.empDTO;

public interface empDAO{
	int insert(String deptno,String name, String id,String pass,String addr,
			int point,String grade,Connection con)throws SQLException;
	ArrayList<empDTO> search(Connection con) throws SQLException;
	int delete(String id,Connection con)throws SQLException;
	empDTO read(String id, Connection con)throws SQLException;
	ArrayList<empDTO> getemplist(String col,String value,String pass,Connection con) throws SQLException;
	int update(empDTO user, Connection con)throws SQLException;
	empDTO login(String id,String pass, Connection con)throws SQLException;
}
