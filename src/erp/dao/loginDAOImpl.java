package erp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.loginDTO;

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
			result= new loginDTO(rs.getString(1), 
					rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
			System.out.println(result);
		}
		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<loginDTO> empList(Connection con) throws SQLException {
			PreparedStatement ptmt  = con.prepareStatement(SELECT_EMPLIST);
			ArrayList<loginDTO> emplist = new ArrayList<loginDTO>();
			loginDTO e =null;
			System.out.println("회원목록 조회");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				e= new loginDTO(rs.getString(1), rs.getString(2), rs.getString(3)
						, rs.getString(4), rs.getString(5));
				emplist.add(e);
			}
			close(rs);
			close(con);
			return emplist;
		}

}
