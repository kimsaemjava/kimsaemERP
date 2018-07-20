package erp.service;

import java.util.ArrayList;

import erp.dto.EmpDTO;
import erp.dto.LoginDTO;

public interface EmpService {

	int insert(EmpDTO emp);
	ArrayList<EmpDTO> getMemberList();
	int delete(String id);
	EmpDTO read(String id);
	ArrayList<EmpDTO> search(String column, String search);
	int update(EmpDTO emp);
	
	LoginDTO login(String id, String pass);

}
