package erp.dto;


public class LoginDTO extends MemberDTO{
	private String job_category;
	private String menupath;
	
	public LoginDTO() {
		super();
	}
	
	public LoginDTO(String id, String pass, String name, String ssn, String birthday, String marry, String gender,
			String position, String duty, String classes, String startday, String endday, String deptno, String curstate,
			String zipcode, String addr, String detailaddr, String phonehome, String phoneco, String phonecell,
			String email, String profile_photo, String job_category, String menupath) {
		super(id, pass, name, ssn, birthday, marry, gender, position, duty, classes, startday, endday, deptno, curstate,
				zipcode, addr, detailaddr, phonehome, phoneco, phonecell, email, profile_photo);
		this.job_category = job_category;
		this.menupath = menupath;
	}


	public String getJob_category() {
		return job_category;
	}


	@Override
	public String toString() {
		return "LoginDTO [job_category=" + job_category + ", menupath=" + menupath + ", toString()=" + super.toString()
				+ ", getId()=" + getId() + ", getPass()=" + getPass() + ", getName()=" + getName() + ", getSsn()="
				+ getSsn() + ", getBirthday()=" + getBirthday() + ", getMarry()=" + getMarry() + ", getGender()="
				+ getGender() + ", getPosition()=" + getPosition() + ", getDuty()=" + getDuty() + ", getClasses()="
				+ getClasses() + ", getStartday()=" + getStartday() + ", getEndday()=" + getEndday() + ", getDeptno()="
				+ getDeptno() + ", getCurstate()=" + getCurstate() + ", getZipcode()=" + getZipcode() + ", getAddr()="
				+ getAddr() + ", getDetailaddr()=" + getDetailaddr() + ", getPhonehome()=" + getPhonehome()
				+ ", getPhoneco()=" + getPhoneco() + ", getPhonecell()=" + getPhonecell() + ", getEmail()=" + getEmail()
				+ ", getProfile_photo()=" + getProfile_photo() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
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
