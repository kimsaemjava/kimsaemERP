package erp.service;

import java.util.ArrayList;

import erp.dto.empDTO;

public interface empService {
	int insert(String deptno,String name, String id,String pass,String addr,
			int point,String grade);
	ArrayList<empDTO> search();
	int delete(String id);
	empDTO read(String id);
	ArrayList<empDTO> getemplist(String col,String value, String pass);
	int update(empDTO user);
	empDTO login(String id, String pass);
}
