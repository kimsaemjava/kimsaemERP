package erp.dto;

import java.sql.Date;

public class DeptDTO extends MemberDTO{
	private String deptno;
	private String deptname;
	private Date deptStartDay;
	private Date deptEndDay;
	private String deptlevel;
	private String deptstep;
	private String deptuppercode;
	private String job_category;
	private String mgr_id;
	private String deptaddr;
	private String depttel;
	
	public DeptDTO() {}
	
	public DeptDTO(String deptno, String deptname, Date deptStartDay, Date deptEndDay, String deptlevel,
			String deptstep, String deptuppercode, String job_category, String mgr_id, String deptaddr,
			String depttel) {
		super();
		this.deptno = deptno;
		this.deptname = deptname;
		this.deptStartDay = deptStartDay;
		this.deptEndDay = deptEndDay;
		this.deptlevel = deptlevel;
		this.deptstep = deptstep;
		this.deptuppercode = deptuppercode;
		this.job_category = job_category;
		this.mgr_id = mgr_id;
		this.deptaddr = deptaddr;
		this.depttel = depttel;
	}
	// 리스트조회용
	public DeptDTO(String id, String name, String duty, String phoneco,String deptname) {
		super(id, name, duty, phoneco);
		this.deptname = deptname;
	}

	@Override
	public String toString() {
		return "DeptDTO [deptno=" + deptno + ", deptname=" + deptname + ", deptStartDay=" + deptStartDay
				+ ", deptEndDay=" + deptEndDay + ", deptlevel=" + deptlevel + ", deptstep=" + deptstep
				+ ", deptuppercode=" + deptuppercode + ", job_category=" + job_category + ", mgr_id=" + mgr_id
				+ ", deptaddr=" + deptaddr + ", depttel=" + depttel + "]";
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public Date getDeptStartDay() {
		return deptStartDay;
	}

	public void setDeptStartDay(Date deptStartDay) {
		this.deptStartDay = deptStartDay;
	}

	public Date getDeptEndDay() {
		return deptEndDay;
	}

	public void setDeptEndDay(Date deptEndDay) {
		this.deptEndDay = deptEndDay;
	}

	public String getDeptlevel() {
		return deptlevel;
	}

	public void setDeptlevel(String deptlevel) {
		this.deptlevel = deptlevel;
	}

	public String getDeptstep() {
		return deptstep;
	}

	public void setDeptstep(String deptstep) {
		this.deptstep = deptstep;
	}

	public String getDeptuppercode() {
		return deptuppercode;
	}

	public void setDeptuppercode(String deptuppercode) {
		this.deptuppercode = deptuppercode;
	}

	public String getJob_category() {
		return job_category;
	}

	public void setJob_category(String job_category) {
		this.job_category = job_category;
	}

	public String getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(String mgr_id) {
		this.mgr_id = mgr_id;
	}

	public String getDeptaddr() {
		return deptaddr;
	}

	public void setDeptaddr(String deptaddr) {
		this.deptaddr = deptaddr;
	}

	public String getDepttel() {
		return depttel;
	}

	public void setDepttel(String depttel) {
		this.depttel = depttel;
	}
	
	
	

	
	
	
	
	
}
