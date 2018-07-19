package emp.service;

import java.util.ArrayList;

import emp.dto.EmpDTO;

public interface EmpService {
	int insert(EmpDTO user);
	ArrayList<EmpDTO> getMemberList();
	int delete(String id);
	
	//180712
	EmpDTO read(String id);
	
	ArrayList<EmpDTO> Search(String column, String search
			, String pass);
	
	int update(EmpDTO data);
	EmpDTO login(String id, String pass);
}
