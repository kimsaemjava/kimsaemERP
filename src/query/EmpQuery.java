package query;
public class EmpQuery {
	public static String EMP_INSERT =
			"insert into member values(?,?,?,?,?,?,?,'사원','사원','5급23호',sysdate,null,?,'수습',?,?,?,?,?,?,?,'myphoto.jpg')";
	public static String EMP_LIST = "select * from kitriemp";
	public static String EMP_DELETE = "delete kitriemp where id=?";
	public static String EMP_READ
			= "select * from kitriemp where id = ?";
	/*public static String LOGIN =
			"select * from kitriemp where id=? and pass=?";*/
	public static String LOGIN
		= "select m.*,d.deptname,j.job_category,j.menupath "
		  +"from member m, dept d, job j "
		  +"where m.deptno = d.deptno "
		  +"and d.job_category = j.job_id "
		  +"and id = ? and pass= ?";
	
	public static String EMP_UPDATE
		= "update kitriemp "
		 + "set addr = ?, point = ? , grade = ? "
		 + "where id = ? ";
	
	public static String EMP_SEARCH1 
		= "select * from kitriemp where name like ?";
	public static String EMP_SEARCH2 
		= "select * from kitriemp where addr like ?";
	public static String EMP_SEARCH3 
		= "select * from kitriemp where id like ?";
}
