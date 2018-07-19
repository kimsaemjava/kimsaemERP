package fw;
public class EmpQuery {
	
	public static String EMP_INSERT = "insert into kitriemp values(?,?,?,?,sysdate,?,?,?)";
	
	public static String EMP_LIST = "select * from kitriemp order by DEPTNO";
	
	public static String EMP_DELETE = "delete kitriemp where id = ?";	
	
	public static String EMP_READ = "select * from kitriemp where id = ?";
	
	public static String EMP_UPDATE = "update kitriemp set addr = ?, point = ?, grade = ? where id = ?";
	
	public static String EMP_SEARCH1 = "select * from kitriemp where name like ?";

	public static String EMP_SEARCH2 = "select * from kitriemp where addr like ?";
	
	public static String EMP_SEARCH3 = "select * from kitriemp where id like ?";
	
	public static String LOGIN = "select * From kitriemp where id = ? and pass = ?";
	
}