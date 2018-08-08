package spring.erp.dto;

import java.sql.Date;

public class BoardDTO {
	private String boardno;
	private String boardctg;
	private String id;
	private Date boarddate;
	private String boardtitle;
	private String boardtxt;
	
	public BoardDTO() {
		super();
	}
	
/*	//write용
	public BoardDTO(String boardctg, String id, String boardtitle, String boardtxt) {
		super();
		this.boardctg = boardctg;
		this.id = id;
		this.boardtitle = boardtitle;
		this.boardtxt = boardtxt;
	}*/

	//조회용
	public BoardDTO(String boardno, String boardctg, String id, Date boarddate, String boardtitle, String boardtxt) {
		super();
		this.boardno = boardno;
		this.boardctg = boardctg;
		this.id = id;
		this.boarddate = boarddate;
		this.boardtitle = boardtitle;
		this.boardtxt = boardtxt;
	}


	@Override
	public String toString() {
		return "BoardDTO [boardno=" + boardno + ", boardctg=" + boardctg + ", id=" + id + ", boarddate=" + boarddate
				+ ", boardtitle=" + boardtitle + ", boardtxt=" + boardtxt + "]";
	}

	public String getBoardno() {
		return boardno;
	}

	public void setBoardno(String boardno) {
		this.boardno = boardno;
	}

	public String getBoardctg() {
		return boardctg;
	}

	public void setBoardctg(String boardctg) {
		this.boardctg = boardctg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBoarddate() {
		return boarddate;
	}

	public void setBoarddate(Date boarddate) {
		this.boarddate = boarddate;
	}

	public String getBoardtitle() {
		return boardtitle;
	}

	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}

	public String getBoardtxt() {
		return boardtxt;
	}

	public void setBoardtxt(String boardtxt) {
		this.boardtxt = boardtxt;
	}
	
}
