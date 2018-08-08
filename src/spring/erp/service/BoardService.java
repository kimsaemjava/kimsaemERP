package spring.erp.service;

import java.util.List;

import spring.erp.dto.BoardDTO;

public interface BoardService {
	int write(BoardDTO board);
	List<BoardDTO> readlist();
	List<BoardDTO> readctglist(String boardctg);
	BoardDTO read(String boardno);
	int delete(String boardno);
	int update(String boardctg, String boardtitle, String boardtxt, String boardno);
}
