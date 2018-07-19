package login.dao;

import java.sql.Connection;
import java.sql.SQLException;

import login.dto.loginDTO;

public interface loginDAO {
	loginDTO login(String id,String pass, Connection con)throws SQLException;
}
