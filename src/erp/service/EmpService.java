package erp.service;

import java.util.ArrayList;

import erp.dto.EmpDTO;
import erp.dto.LoginDTO;
import erp.dto.MemberDTO;

public interface EmpService {
	int insert(MemberDTO user);
	ArrayList<MemberDTO> getMemberList();
	int delete(String id);
	MemberDTO read(String id);
	ArrayList<EmpDTO> search(String column, String search
					,String pass);
	int update(EmpDTO user);
	LoginDTO login(String id,String pass);
}
