package emp.dao;

import static fw.DBUtil.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emp.dto.EmpDTO;
import emp.dto.LoginDTO;

import static query.EmpQuery.*;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public LoginDTO login(String id, String pass, Connection con) throws SQLException {

		LoginDTO user = null;
		PreparedStatement ptmt = con.prepareStatement(LOGIN);
		
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ResultSet rs = ptmt.executeQuery();

		if (rs.next()) {
			user = new LoginDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), 
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 
					rs.getDate(11), rs.getDate(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), 
					rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22),
					rs.getString(23), rs.getString(24), rs.getString(25));
		}
		close(rs);
		close(ptmt);
		
		return user;
		
		
	}


				
		
}
