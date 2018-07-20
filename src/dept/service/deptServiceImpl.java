package dept.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import dept.dao.deptDAO;
import dept.dao.deptDAOImpl;
import dept.dto.deptDTO;

import static util.DBUtil.*;

public class deptServiceImpl implements deptService{

	@Override
	public ArrayList<deptDTO> deptlist() {
		deptDAO dao = new deptDAOImpl();
		ArrayList<deptDTO> SeatGetFalse =null;
		Connection con = null;
		try {
			con = DBconnect();
			SeatGetFalse =dao.deptlist(con);
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			close(con);
		}
		return SeatGetFalse;
	}

	@Override
	public int insert(String id, String pass, String name, String ssn, String birth, int marry, String deptno,
			String zipcode, String addr, String detailaddr, String phonehome, String phoneco, String phonecell,
			String email) {
		int result=0;
		System.out.println("서비스확인");
		deptDAO dao = new deptDAOImpl();
		Connection con =null;
		try{
			con = DBconnect();
			result=dao.insert(id, pass, name, ssn, birth, marry, deptno, zipcode, addr, detailaddr, phonehome, phoneco, phonecell, email, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return result;
	}


}
