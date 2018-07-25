package erp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.EmpDTO;
import erp.dto.LoginDTO;
import erp.dto.MemberDTO;

public interface EmpDAO {
	int insert(MemberDTO user,Connection con) throws SQLException; 
	ArrayList<MemberDTO> getMemberList(Connection con) 
										throws SQLException;
	int delete(String id,Connection con) throws SQLException; 
	EmpDTO read(String id,Connection con) throws SQLException;
	ArrayList<EmpDTO> search(String column, String search,
			String pass, Connection con) 
			throws SQLException;
	int update(EmpDTO user,Connection con) throws SQLException; 
	LoginDTO login(String id,String pass,Connection con) 
								throws SQLException;
	boolean idCheck(String id,Connection con) throws SQLException;
}














