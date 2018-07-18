package fw;

import emp.dao.EmpDAOImpl;

//sql은 추후에 XML파일로 관리될 것임.
public class EmpQuery {
	public static final String EMP_INSERT
					="insert into kitriemp values(?,?,?,?,sysdate,?,?,?)";
	public static final String EMP_LIST
					="select * from kitriemp";
	public static final String EMP_DELETE
					="delete kitriemp where id=?";
	public static final String EMP_READ
					="select * from kitriemp where id=?";
	
	public static final String EMP_SEARCH1
					="select * from kitriemp where name like ?";
	public static final String EMP_SEARCH2
					="select * from kitriemp where addr like ?";
	public static final String EMP_SEARCH3
					="select * from kitriemp where id like ?";
	
	public static final String EMP_UPDATE
					="update kitriemp set addr=?, grade=?, point=? where id=?";
	
	public static final String LOGIN
					="select * from kitriemp where id=? and pass=?";
}
