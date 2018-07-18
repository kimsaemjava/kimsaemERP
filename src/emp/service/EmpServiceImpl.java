package emp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;
import emp.dao.EmpDAO;
import emp.dao.EmpDAOImpl;
import emp.dto.EmpDTO;

import static db.util.DBUtil.*;

public class EmpServiceImpl implements EmpService{

	@Override
	public int insert(EmpDTO user) {
		int result = 0;
		//System.out.println("**********serviceImple의 insert**********");
		
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;
		
		try{
			con = getConnect();
			result = dao.insert(user, con);
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			close(con);
		}
		
		return result;
	}

	@Override
	public ArrayList<EmpDTO> getMemberList() {
		//서비스단에는 DAO호출결과가 들어올거니 null만해도 가능
		ArrayList<EmpDTO> userlist = null;
		Connection con = null;
		EmpDAO dao = new EmpDAOImpl();
		
		try{
			System.out.println("서비스 호출");
			con = getConnect();
			userlist = dao.getMemberList(con);	
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			close(con);
		}
		
		return userlist;
	}

	@Override
	public int delete(String id) {
		int result = 0;
		
		Connection con = null;
		EmpDAO dao = new EmpDAOImpl();
		
		try{
			System.out.println("서비스호출");
			con = getConnect();
			result = dao.delete(id, con);
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			close(con);
		}
		
		return result;
	}

	@Override
	public EmpDTO read(String id) {
		EmpDTO user = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;
		
		
		try{
			System.out.println("서비스호출");
			con = getConnect();
			user = dao.read(id, con);
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			close(con);
		}

		return user;
	}

	@Override
	public ArrayList<EmpDTO> Search(String column, String search, String pass) {
		ArrayList<EmpDTO> userlist = null;
		Connection con = null;
		EmpDAO dao = new EmpDAOImpl();
		
		try{
			con = getConnect();
			userlist = dao.Search(column, search, pass, con);
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			close(con);
		}
		
		return userlist;
	}

	@Override
	public int update(EmpDTO data) {
		int result = 0;
		System.out.println("**********serviceImple의 update**********");
		
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;
		
		try{
			con = getConnect();
			result = dao.update(data, con);
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			close(con);
		}
		
		return result;
	}

	@Override
	public EmpDTO login(String id, String pass) {
		EmpDTO user = null;
		EmpDAO dao = new EmpDAOImpl();
		Connection con = null;
		
		try{
			System.out.println("서비스호출");
			con = getConnect();
			user = dao.login(id, pass, con);
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			close(con);
		}

		return user;
		}
}
