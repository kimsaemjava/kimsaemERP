package emp.dao;

import java.sql.Connection;
import java.sql.SQLException;

import emp.dto.LoginDTO;

public interface LoginDAO {

	LoginDTO login(String id, String pass, Connection con) throws SQLException;
}
