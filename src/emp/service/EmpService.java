package emp.service;

import java.util.ArrayList;
import emp.dto.EmpDTO;

public interface EmpService {

	int insert(EmpDTO emp);
	ArrayList<EmpDTO> getMemberList();
	int delete(String id);
	EmpDTO read(String id);
	ArrayList<EmpDTO> search(String column, String search);
	int update(EmpDTO emp);
	
	EmpDTO login(String id, String pass);

}
