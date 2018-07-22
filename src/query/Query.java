package query;

public class Query {
	//사원 목록및 로그인
	public static final String SELECT_LOGIN="select m.id,m.pass,j.job_category,menupath,profile_photo from member m, dept d, job j where m.deptno=d.deptno and j.job_id=d.job_category and m.id like ? and m.pass like ?";
//	public static final String SELECT_LOGIN="select m.id,m.pass from member m, dept d, job j where m.deptno=d.deptno and j.job_id=d.job_category and m.id like ? and m.pass like ?";
	public static final String INSERT_EMP="insert into member values(?,?,?,?,to_date(?,'yy/mm/dd'),?,'0','직원','사원','1급1호봉',sysdate,null,?,'재직',?,?,?,?,?,?,?,'myphoto.jpg')";
	public static final String SELECT_EMPLIST="SELECT M.DEPTNO,D.DEPTNAME,NAME,POSITION,PHONECO FROM MEMBER M,DEPT D WHERE M.DEPTNO=D.DEPTNO";
	public static final String SELECT_EMP="SELECT * FROM MEMBER WHERE NAME = ?";
	//DEPT목록
	public static final String SELECT_DEPTLIST = "SELECT DEPTNO,DEPTNAME FROM DEPT";
}
