package dept.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dept.dto.deptDTO;

import static util.DBUtil.*;
import static query.Query.*;
public class deptDAOImpl implements deptDAO {

	@Override
	public ArrayList<deptDTO> deptlist(Connection con) throws SQLException {
		PreparedStatement ptmt  = con.prepareStatement(SELECT_DEPTLIST);
		ArrayList<deptDTO> deptlist = new ArrayList<deptDTO>();
		deptDTO e =null;
		System.out.println("회원목록 조회");
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			e= new deptDTO(rs.getString(1), rs.getString(2));
			deptlist.add(e);
		}
		close(rs);
		close(con);
		return deptlist;
	}

	@Override
	public int insert(String id, String pass, String name, String ssn, String birth, int marry, String deptno,
			String zipcode, String addr, String detailaddr, String phonehome, String phoneco, String phonecell,
			String email, Connection con) throws SQLException {
		int result=0;
		PreparedStatement ptmt = con.prepareStatement(INSERT_EMP);
		con = DBconnect();
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ptmt.setString(3, name);
		ptmt.setString(4, ssn);
		ptmt.setString(5, birth);
		ptmt.setInt(6, marry);
		ptmt.setString(7, deptno);
		ptmt.setString(8, zipcode);
		ptmt.setString(9, addr);
		ptmt.setString(10, detailaddr);
		ptmt.setString(11, phonehome);
		ptmt.setString(12, phoneco);
		ptmt.setString(13, phonecell);
		ptmt.setString(14, email);
		result=ptmt.executeUpdate();
		close(ptmt);
		return result;
	}
}
