package emp.service;

import java.util.ArrayList;

import emp.dto.EmpDTO;
import emp.dto.LoginDTO;

public interface EmpService {
	int insert(EmpDTO user);
	ArrayList<EmpDTO> getMemberList();
	int delete(String id);
	EmpDTO read(String id);
	ArrayList<EmpDTO> search(String column, String search, String pass);
	int update(EmpDTO user);
	LoginDTO login(String id, String pass);
	
}
