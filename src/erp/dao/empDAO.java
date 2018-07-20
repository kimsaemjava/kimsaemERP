package erp.dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.DeptDTO;
import erp.dto.MemberDTO;
import erp.dto.empDTO;

public interface empDAO {
	ArrayList<empDTO> search(Connection con) throws SQLException;
	int delete(String id,Connection con)throws SQLException;
	MemberDTO read(String id, Connection con)throws SQLException;
	ArrayList<empDTO> getemplist(String col,String value,String pass,Connection con) throws SQLException;
	int update(empDTO user, Connection con)throws SQLException;
	empDTO login(String id,String pass, Connection con)throws SQLException;
	int insert(MemberDTO dto , Connection con)throws SQLException;
	ArrayList<DeptDTO> emplist(Connection con) throws SQLException;
}
