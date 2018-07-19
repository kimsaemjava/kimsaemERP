package query;

public class ERPQuery {
	public static final String ERP_SELECT_LOGIN=
			"select m.*, j.job_category, j.menupath "+
			"from member m, dept d, job j "+
			" where m.deptno = d.deptno and d.job_category = j.job_id "+
			"	and m.id = ? and m.pass= ? ";
	

}
