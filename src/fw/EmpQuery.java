package fw;

public class EmpQuery {
	public static final String EMP_INSERT
				="insert into kitriemp values(?,?,?,?,TO_DATE(SYSDATE,'YY/MM/DD'),?,?,?)";
				  /*="insert into kitriemp values(?,?,?,?,SYSDATE,?,?,?)";*/
	
	public static final String EMP_LIST
				="select * from kitriemp";
	
	public static final String EMP_DELETE
				="delete from kitriemp where id=?";
	
	public static final String EMP_READ
				="select * from kitriemp where id=?";
	
	public static final String EMP_SEARCH1
	= "select * from kitriemp where name like ?";
	public static final String EMP_SEARCH2
	= "select * from kitriemp where addr like ?";
	public static final String EMP_SEARCH3
	= "select * from kitriemp where id like ?";
	/*="select * from kitriemp where ?=?";*/
	/*="select * from kitriemp where ";*/
	/*="select * from kitriemp where ?=?";*/
	
	public static final String EMP_UPDATE
	= "update kitriemp set "
	+"addr=?, point=?, grade=? "
	+"where id like ? ";
	
	public static final String EMP_LOGIN
	= "select * from kitriemp where id = ? and pass = ?";
}