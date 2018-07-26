package erp.service;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dao.empDAO;
import erp.dao.empDAOImpl;
import erp.dto.DeptDTO;
import erp.dto.MemberDTO;
import erp.dto.empDTO;

public class empServiceImpl implements empService{

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
	public MemberDTO read(String id) {
		MemberDTO user = null;
		empDAO dao = new empDAOImpl();
		Connection con =null;
		System.out.println("read서비스"+id);
		try{
			con = getConnect();
			user =dao.read(id,con);
		}catch(SQLException e){
			e.printStackTrace();
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

	@Override
	public ArrayList<DeptDTO> emplist() {
		ArrayList<DeptDTO> list = null;
		Connection con =null;
		System.out.println("emplist 서비스");
		empDAO dao = new empDAOImpl();
		try {
			con= getConnect();
			list = dao.emplist(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return list;
	}

	@Override
	public boolean idCheck(String id) {
		boolean check = false;
		Connection con = null;
		empDAO dao = new empDAOImpl();
		try {
			con = getConnect();
			check = dao.idCheck(id, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return check;
	}

	@Override
	public ArrayList<MemberDTO> emptree(String deptno) {
		ArrayList<MemberDTO> dtolist = null;
		Connection con =null;
		empDAO dao = new empDAOImpl();
		con = getConnect();
		try {
			dtolist = dao.emptree(deptno, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		
		return dtolist;
	}
	


}
