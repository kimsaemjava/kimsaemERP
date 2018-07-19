package login.service;

import java.sql.Connection;
import java.sql.SQLException;

import login.dao.loginDAO;
import login.dao.loginDAOImpl;
import login.dto.loginDTO;

import static util.DBUtil.*;

public class loginServiceImpl implements loginService{

	@Override
	public loginDTO login(String id, String pass) {
		loginDTO user = null;
		loginDAO dao = new loginDAOImpl();
		Connection con =null;
		try{
			con =DBconnect();
			user =dao.login(id, pass, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return user;
	}


}
