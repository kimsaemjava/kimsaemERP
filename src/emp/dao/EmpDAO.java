package emp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import emp.dto.EmpDTO;

public interface EmpDAO {
	
	int insert(EmpDTO emp, Connection con) throws SQLException;				// 사원등록
	
	ArrayList<EmpDTO> getMemberList(Connection con) throws SQLException;	// 사원목록출력
	
	int delete(String id, Connection con) throws SQLException;				// 사원삭제
	
	EmpDTO read(String id, Connection con) throws SQLException;				// 사원조회
	
	ArrayList<EmpDTO> search(String column, String search, String pass, Connection con)	// 사원검색 
									throws SQLException;
	
	int update(EmpDTO user, Connection con) throws SQLException;			// 사원수정
	
	EmpDTO login(String id, String pass, Connection con) throws SQLException;	// 로그인
}
