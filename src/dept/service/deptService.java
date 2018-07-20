package dept.service;


import java.sql.Date;
import java.util.ArrayList;

import dept.dto.deptDTO;


public interface deptService {
	ArrayList<deptDTO> deptlist();
	int insert(String id,String pass, String name, String ssn
			,String birth,int marry,String deptno,String zipcode,String addr
			,String detailaddr,String phonehome, String phoneco
			,String phonecell,String email);
}
