package spring.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import spring.erp.dao.BoardDAO;
import spring.erp.dto.BoardDTO;

@Service("boardservice")
public class BoardServiceImpl implements BoardService {
	@Autowired
	@Qualifier("boarddao")
	BoardDAO dao;
	
	@Override
	public int write(BoardDTO board) {
		int result = dao.write(board);
		return result;
	}

	@Override
	public List<BoardDTO> readlist() {
		List<BoardDTO> boardlist = dao.readlist();
		return boardlist;
	}
	
	@Override
	public List<BoardDTO> readctglist(String boardctg) {
		List<BoardDTO> boardctglist = dao.readctglist(boardctg);
		return boardctglist;
	}

	@Override
	public BoardDTO read(String boardno) {
		BoardDTO board = dao.read(boardno);
		return board;
	}

	@Override
	public int delete(String boardno) {
		int result = dao.delete(boardno);
		return result;
	}

	@Override
	public int update(String boardctg, String boardtitle, String boardtxt, String boardno) {
		int result = dao.update(boardctg, boardtitle, boardtxt, boardno);
		return result;
	}

}
