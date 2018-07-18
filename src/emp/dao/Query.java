package emp.dao;

public class Query {
	public static final String INSERT_REG="insert into kitriemp values(?,?,?,?,sysdate,?,?,?)";
	public static final String SELECT_EMP="SELECT * from kitriemp";
	public static final String DELETE_EMP="DELETE KITRIEMP WHERE ID=?";
	public static final String SELECT_DEPTNO="SELECT * FROM KITRIEMP WHERE id=?";
	public static final String UPDATE_EMP="UPDATE KITRIEMP set addr=?,grade=?,point=? where id=?";
	public static final String SELECT_LOGIN="SELECT * FROM KITRIEMP WHERE ID LIKE ? AND PASS LIKE ?";
}
