package erp.dao;

import java.sql.Connection;
import java.sql.SQLException;

import erp.dto.LoginDTO;


public interface LoginDAO {

	LoginDTO login(String id, String pass, Connection con)throws SQLException;
}
