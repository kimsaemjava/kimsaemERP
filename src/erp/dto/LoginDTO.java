package erp.dto;

import java.sql.Date;

public class LoginDTO extends MemberDTO{
	private String job_category;
	private String menupath;
	
	public LoginDTO() {
		super();
	}
	
	public LoginDTO(String id, String pass, String name, String ssn, Date birthday, String marry, String gender,
			String position, String duty, String classes, Date startday, Date endday, String deptno, String curstate,
			String zipcode, String addr, String detailaddr, String phonehome, String phoneco, String phonecell,
			String email, String profile_photo, String job_category, String menupath) {
		super(id, pass, name, ssn, birthday, marry, gender, position, duty, classes, startday, endday, deptno, curstate,
				zipcode, addr, detailaddr, phonehome, phoneco, phonecell, email, profile_photo);
		this.job_category = job_category;
		this.menupath = menupath;
	}


	public LoginDTO(String job_category, String menupath) {

	}


	public String getJob_category() {
		return job_category;
	}


	public void setJob_category(String job_category) {
		this.job_category = job_category;
	}


	public String getMenupath() {
		return menupath;
	}


	public void setMenupath(String menupath) {
		this.menupath = menupath;
	}


	
	

	

	
}
