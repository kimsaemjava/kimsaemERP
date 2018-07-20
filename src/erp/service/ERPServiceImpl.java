package erp.service;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.SQLException;

import erp.dao.LoginDAO;
import erp.dao.LoginDAOImpl;
import erp.dto.LoginDTO;

public class ERPServiceImpl implements ERPService {

	@Override
	public LoginDTO login(String id, String pass) {
		LoginDTO user = null;
		LoginDAO dao = new LoginDAOImpl();
		Connection con =null;
		try{
			con =getConnect();
			user =dao.login(id, pass, con);
			System.out.println(user.toString());
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return user;
		
	}

}
