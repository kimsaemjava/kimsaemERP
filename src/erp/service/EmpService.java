package erp.service;

import java.util.ArrayList;

import erp.dto.EmpDTO;
import erp.dto.LoginDTO;
import erp.dto.MemberDTO;

public interface EmpService {


	int delete(String id);
	EmpDTO read(String id);
	ArrayList<EmpDTO> search(String column, String search);
	int update(EmpDTO emp);
	
	LoginDTO login(String id, String pass);
	int insert(MemberDTO emp);
	
	ArrayList<LoginDTO> getMemberList();
}
