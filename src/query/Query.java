package query;

public class Query {
	public static final String SELECT_LOGIN="select m.id,m.pass,menupath,profile_photo from member m, dept d, job j where m.deptno=d.deptno and j.job_id=d.job_category and m.id like ? and m.pass like ?";
//	public static final String SELECT_LOGIN="select m.id,m.pass from member m, dept d, job j where m.deptno=d.deptno and j.job_id=d.job_category and m.id like ? and m.pass like ?";
}
