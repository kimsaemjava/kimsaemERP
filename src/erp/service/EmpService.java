package erp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;

import erp.dto.EmpDTO;
import erp.dto.LoginDTO;
import erp.dto.MemberDTO;

public interface EmpService {
	
	int insert(MemberDTO user);	
	
	// ArrayList<EmpDTO> getMemberList();
	ArrayList<LoginDTO> getMemberList();
	
	int delete(String id);
	
	// EmpDTO read(String id);
	MemberDTO read(String id);
	
	ArrayList<EmpDTO> search(String column, String search, String pass);
	
	int update(EmpDTO user);
	
	// EmpDTO login(String id, String pass);
	LoginDTO login(String id, String pass);
	
	boolean idCheck(String id);

}