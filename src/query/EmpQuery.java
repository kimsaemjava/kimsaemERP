package query;

public class EmpQuery {
	public static final String INSERT_REG="insert into kitriemp values(?,?,?,?,sysdate,?,?,?)";
	public static final String SELECT_EMP="SELECT * from kitriemp";
	public static final String DELETE_EMP="DELETE KITRIEMP WHERE ID=?";
	public static final String SELECT_DEPTNO="SELECT * FROM KITRIEMP WHERE id=?";
	public static final String UPDATE_EMP="UPDATE KITRIEMP set addr=?,grade=?,point=? where id=?";
	public static final String SELECT_LOGIN="SELECT * FROM KITRIEMP WHERE ID LIKE ? AND PASS LIKE ?";
	
	public static final String LOGIN=
			"select m.*, j.job_category, j.menupath "+
			"from member m, dept d, job j "+
			" where m.deptno = d.deptno and d.job_category = j.job_id "+
			"	and m.id = ? and m.pass= ? ";
	public static final String INSERT_MEMBER=
			"insert into member values( " + 
			" ?, ?, ?, ?, to_date( ? ,'YYYY/MM/DD'), "
			+ "?, null, null, null, null, "
			+ "sysdate, null, ?, null, ?, ?, null, "
			+ "?, ?, ?, ?, ?)";
	public static final String DEPTNAME_SELECT=
			"select deptno, deptname from dept";
}
