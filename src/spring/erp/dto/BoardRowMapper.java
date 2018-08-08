package spring.erp.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import erp.dto.EmpDTO;

public class BoardRowMapper implements RowMapper<BoardDTO>{

	@Override
	public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDTO board = new BoardDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
				rs.getDate(4), rs.getString(5), rs.getString(6));
		return board;
	}
}
