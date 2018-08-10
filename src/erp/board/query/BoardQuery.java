package erp.board.query;

import java.sql.Date;

public class BoardQuery {
	public static final String WRITE_BOARD
		="insert into board "
				+ "values (board_seq.nextval,?,?,sysdate,?,?)";
	
	public static final String DELETE_BOARD
		="delete from board "
				+ "where boardno = ?";
	
	public static final String SELECT_BOARD
		="select * from board "
				+ "where boardctg = ?";
	
	public static final String READ_BOARD
		="select * from board "
				+ "where boardno = ?";
	
	public static final String UPDATE_BOARD
		="update board "
				+ "set boardctg=?, boardtitle=?, boardtxt=?";

}
