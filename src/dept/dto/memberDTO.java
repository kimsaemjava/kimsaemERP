package dept.dto;

import java.sql.Date;

public class memberDTO {
	private int deptno;
	private String name;
	private String id;
	private String pass;
	private String ssn;
	private Date birth;
	private String marry;
	private String zipcode;
	private String addr;
	private String detailaddr;
	private String phonehome;
	private String phoneco;
	private String phonecell;
	private String email;
	
	
	public memberDTO() {
		super();
	}
	
	public memberDTO(int deptno, String name, String id, String pass, String ssn, Date birth, String marry,
			String zipcode, String addr, String detailaddr, String phonehome, String phoneco, String phonecell,
			String email) {
		super();
		this.deptno = deptno;
		this.name = name;
		this.id = id;
		this.pass = pass;
		this.ssn = ssn;
		this.birth = birth;
		this.marry = marry;
		this.zipcode = zipcode;
		this.addr = addr;
		this.detailaddr = detailaddr;
		this.phonehome = phonehome;
		this.phoneco = phoneco;
		this.phonecell = phonecell;
		this.email = email;
	}

	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getMarry() {
		return marry;
	}
	public void setMarry(String marry) {
		this.marry = marry;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDetailaddr() {
		return detailaddr;
	}
	public void setDetailaddr(String detailaddr) {
		this.detailaddr = detailaddr;
	}
	public String getPhonehome() {
		return phonehome;
	}
	public void setPhonehome(String phonehome) {
		this.phonehome = phonehome;
	}
	public String getPhoneco() {
		return phoneco;
	}
	public void setPhoneco(String phoneco) {
		this.phoneco = phoneco;
	}
	public String getPhonecell() {
		return phonecell;
	}
	public void setPhonecell(String phonecell) {
		this.phonecell = phonecell;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
