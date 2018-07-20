package erp.dto;

import java.sql.Date;

public class LoginDTO extends MemberDTO {
	private String job_category;
	private String deptname;
	private String menupath;

	public LoginDTO() {
	}

	public LoginDTO(String id, String pass, String name, String ssn, Date birthday, String marry, String gender,
			String position, String duty, String classes, Date startday, Date endday, String deptno, String curstate,
			String zipcode, String addr, String detailaddr, String phonehome, String phoneco, String phonecell,
			String email, String profile_photo, String deptname, String job_category, String menupath) {
		super(id, pass, name, ssn, birthday, marry, gender, position, duty, classes, startday, endday, deptno, curstate,
				zipcode, addr, detailaddr, phonehome, phoneco, phonecell, email, profile_photo);
		this.job_category = job_category;
		this.menupath = menupath;
		this.deptname = deptname;
	}

	public String getJob_category() {
		return job_category;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
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

	@Override
	public String toString() {
		return "LoginDTO [job_category=" + job_category + ", menupath=" + menupath + ", getJob_category()="
				+ getJob_category() + ", getMenupath()=" + getMenupath() + ", getId()=" + getId() + ", getPass()="
				+ getPass() + ", getName()=" + getName() + ", getSsn()=" + getSsn() + ", getBirthday()=" + getBirthday()
				+ ", getMarry()=" + getMarry() + ", getGender()=" + getGender() + ", getPosition()=" + getPosition()
				+ ", getDuty()=" + getDuty() + ", getClasses()=" + getClasses() + ", getStartday()=" + getStartday()
				+ ", getEndday()=" + getEndday() + ", getDeptno()=" + getDeptno() + ", getCurstate()=" + getCurstate()
				+ ", getZipcode()=" + getZipcode() + ", getAddr()=" + getAddr() + ", getDetailaddr()=" + getDetailaddr()
				+ ", getPhonehome()=" + getPhonehome() + ", getPhoneco()=" + getPhoneco() + ", getPhonecell()="
				+ getPhonecell() + ", getEmail()=" + getEmail() + ", getProfile_photo()=" + getProfile_photo()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}