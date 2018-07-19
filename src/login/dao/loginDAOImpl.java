package login.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.dto.loginDTO;

import static util.DBUtil.*;
import static query.Query.*;
public class loginDAOImpl implements loginDAO {

	@Override
	public loginDTO login(String id, String pass, Connection con) throws SQLException {
		loginDTO result=null;
		PreparedStatement ptmt = con.prepareStatement(SELECT_LOGIN);
		con = DBconnect();
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()){
			result= new loginDTO(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println("이미지경로"+rs.getString(3));
			System.out.println("모르는경로"+rs.getString(4));
		}
		close(ptmt);
		return result;
	}

}
