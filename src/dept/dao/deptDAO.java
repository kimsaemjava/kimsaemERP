package dept.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import dept.dto.deptDTO;

public interface deptDAO {
	ArrayList<deptDTO> deptlist(Connection con)throws SQLException;
	int insert(String id,String pass, String name, String ssn
			,String birth,int marry,String deptno,String zipcode,String addr
			,String detailaddr,String phonehome, String phoneco
			,String phonecell,String email,Connection con)throws SQLException;
}
