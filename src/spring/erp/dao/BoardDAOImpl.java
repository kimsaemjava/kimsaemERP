package spring.erp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.erp.dto.BoardDTO;
import spring.erp.dto.BoardRowMapper;

@Repository("boarddao")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public int write(BoardDTO board) {
		String sql = "insert into board values(board_seq.nextval,?,?,sysdate,?,?)";
		int result = template.update(sql, board.getBoardctg(),
				board.getId(), board.getBoardtitle(), board.getBoardtxt());
		return result;
	}
	
	@Override
	public List<BoardDTO> readlist() {
		return template.query("select * from board", new BoardRowMapper());
	}
	
	@Override
	public List<BoardDTO> readctglist(String boardctg) {
		return template.query("select * from board where boardctg = ?", new Object[]{boardctg}, new BoardRowMapper());
	}

	@Override
	public BoardDTO read(String boardno) {
		try{
			return template.queryForObject("select * from board where boardno=?", new Object[]{boardno}, new BoardRowMapper());
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public int delete(String boardno) {
		String sql = "delete from board where boardno=?";
		int result = template.update(sql,boardno);
		return result;
	}

	@Override
	public int update(String boardctg, String boardtitle, String boardtxt, String boardno) {
		String sql = "update board set boardctg=?, boardtitle=?, boardtxt=? where boardno=?";
		int result = template.update(sql,boardctg,boardtitle,boardtxt,boardno);
		return result;
	}


}
