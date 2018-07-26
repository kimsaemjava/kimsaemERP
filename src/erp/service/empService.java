package erp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.DeptDTO;
import erp.dto.MemberDTO;
import erp.dto.empDTO;

public interface empService {
/*	int insert(String deptno,String name, String id,String pass,String addr,
			int point,String grade);*/
	ArrayList<empDTO> search();
	int delete(String id);
	MemberDTO read(String id);
	ArrayList<empDTO> getemplist(String col,String value, String pass);
	int update(empDTO user);
	empDTO login(String id, String pass);
	int insert(MemberDTO dto);
	ArrayList<DeptDTO> emplist();
	boolean idCheck(String id);
	ArrayList<MemberDTO> emptree(String deptno);
}
