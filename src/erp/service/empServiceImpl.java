package erp.service;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dao.empDAO;
import erp.dao.empDAOImpl;
import erp.dto.MemberDTO;
import erp.dto.empDTO;

public class empServiceImpl implements empService{

/*	@Override
	public int insert(MemberDTO dto) {
		int result=0;
		System.out.println("서비스확인");
		empDAO dao = new empDAOImpl();
		Connection con =null;
		try{
			con = getConnect();
			result=dao.insert(deptno, name, id, pass, addr, point, grade, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return result;
	}*/

	@Override
	public ArrayList<empDTO> search() {
		empDAO dao = new empDAOImpl();
		ArrayList<empDTO> SeatGetFalse =null;
		Connection con = null;
		try {
			con = getConnect();
			SeatGetFalse =dao.search(con);
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			close(con);
		}
		return SeatGetFalse;
	}

	@Override
	public int delete(String id) {
		int result=0;
		System.out.println("삭제확인");
		empDAO dao = new empDAOImpl();
		Connection con =null;
		try{
			con = getConnect();
			result=dao.delete(id, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return result;
	}

	@Override
	public empDTO read(String id) {
		empDTO user = null;
		empDAO dao = new empDAOImpl();
		Connection con =null;
		try{
			con =getConnect();
			user =dao.read(id,con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return user;
	}

	@Override
	public ArrayList<empDTO> getemplist(String col, String value,String pass) {
		empDAO dao = new empDAOImpl();
		ArrayList<empDTO> SeatGetFalse =null;
		Connection con = null;
		try {
			con = getConnect();
			SeatGetFalse =dao.getemplist(col, value,pass, con);
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			close(con);
		}
		return SeatGetFalse;
	}

	@Override
	public int update(empDTO user) {
		int result = 0;
		Connection con = null;	
		empDAO dao = new empDAOImpl();
		System.out.println("update service");
		try {
			con = getConnect();
			result = dao.update(user, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(con);
		return result;
	}

	@Override
	public empDTO login(String id, String pass) {
		empDTO user = null;
		empDAO dao = new empDAOImpl();
		Connection con =null;
		try{
			con =getConnect();
			user =dao.login(id, pass, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return user;
	}

	@Override
	public int insert(MemberDTO dto){
		int result=0;
		System.out.println("서비스확인");
		empDAO dao = new empDAOImpl();
		Connection con =null;
		try{
			con = getConnect();
			result=dao.insert(dto, con);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(con);
		}
		return result;
		
	}
	


}
