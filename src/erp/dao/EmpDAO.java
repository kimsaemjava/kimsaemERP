package erp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.EmpDTO;
import erp.dto.LoginDTO;
import erp.dto.MemberDTO;

public interface EmpDAO {

	//int insert(EmpDTO emp, Connection con) throws SQLException;
	//ArrayList<EmpDTO> getMemberList(Connection con) throws SQLException;
	int delete(String id, Connection con) throws SQLException;
	EmpDTO read(String id,Connection con) throws SQLException;
	ArrayList<EmpDTO> search(String column, String search, Connection con) throws SQLException;
	int update(EmpDTO emp, Connection con) throws SQLException;
	
	LoginDTO login(String id, String pass, Connection con) throws SQLException;
	
	int insert(MemberDTO emp, Connection con) throws SQLException;
	ArrayList<LoginDTO> getMemberList(Connection con) throws SQLException;

}
