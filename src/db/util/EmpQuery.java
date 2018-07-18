package db.util;
//강사님 추가 작성부분
//자주 바뀌는 부분은 설정파일로 분류 한다.

//sql은 추후에 XML파일로 관리 될것임을 인지.
public class EmpQuery {
	public static final String EMP_INSERT
					= "insert into kitriemp values(?,?,?,?,sysdate,?,?,?)";
	public static final String EMP_LIST
					= "select * from kitriemp";
	public static final String EMP_DELETE
					= "delete kitriemp where id=?";
	public static final String EMP_READ 
					= "select * from kitriemp where id=?";
	
	public static final String EMP_SEARCH1	//column에는 ?가 올수 없다. 동적쿼리가 필요.
											//?=? XXXXXX 안됨
						//***
					= "select * from kitriemp where name like ?";
	public static final String EMP_SEARCH2	
					= "select * from kitriemp where addr like ?";
	public static final String EMP_SEARCH3	
					= "select * from kitriemp where id like ?";
	
	public static final String EMP_UPDATE	
					= "update kitriemp set addr=?, grade=?, point=? where id like ?";
	
	public static final String EMP_LOGIN
					= "select * from kitriemp where id=? and pass=?";
}
