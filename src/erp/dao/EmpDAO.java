package erp.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.EmpDTO;
import erp.dto.LoginDTO;
import erp.dto.MemberDTO;

import java.sql.Connection;

public interface EmpDAO {
	
	int insert(MemberDTO emp, Connection con) throws SQLException;				// 사원등록
	
	// ArrayList<EmpDTO> getMemberList(Connection con) throws SQLException;	
	ArrayList<LoginDTO> getMemberList(Connection con) throws SQLException;	// 사원목록출력
	
	int delete(String id, Connection con) throws SQLException;				// 사원삭제
	
	// EmpDTO read(String id, Connection con) throws SQLException;				// 사원조회
	MemberDTO read(String id, Connection con) throws SQLException;
	
	ArrayList<EmpDTO> search(String column, String search, String pass, Connection con)	
									throws SQLException;					// 사원검색 
	
	int update(EmpDTO user, Connection con) throws SQLException;			// 사원수정
	
	LoginDTO login(String id, String pass, Connection con) throws SQLException;	// 로그인
	
	boolean idCheck(String id,Connection con) throws SQLException;	// 아이디 중복확인

}
