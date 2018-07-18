package emp.dto;

import java.sql.Date;

public class EmpDTO {

	private String emp_id;
	private String pass;
	private String name;
	private String addr;
	private Date hiredate;
	private String grade;
	private int point;
	private String deptNo;
	//
	private String column;
	private String search;
	
	
	public EmpDTO(){}
	//삽입용
	
	public EmpDTO(String emp_id, String pass, String name, String addr, Date hiredate, String grade, int point,
			String deptNo) {
		super();
		this.emp_id = emp_id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.hiredate = hiredate;
		this.grade = grade;
		this.point = point;
		this.deptNo = deptNo;
	}
	
	//조회용
	
	@Override
	public String toString() {
		return "EmpDTO [deptNo=" + deptNo + ", name=" + name + ", emp_id=" + emp_id + ", pass=" + pass + ", addr="
				+ addr + ", point=" + point + ", grade=" + grade + ", hiredate=" + hiredate + "]";
	}
	public EmpDTO(String emp_id, String pass, String name, String addr, String grade, int point, String deptNo) {
		super();
		this.emp_id = emp_id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.grade = grade;
		this.point = point;
		this.deptNo = deptNo;
	}
	
	//search
	public EmpDTO(String column, String search) {
		super();
		this.column = column;
		this.search = search;
	}
	
	//update
	public EmpDTO(String id, String addr, String grade, int point) {
		super();
		this.emp_id = id;
		this.addr = addr;
		this.grade = grade;
		this.point = point;
	}
	
	public String getDeptNo() {
		return deptNo;
	}
	

	
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	
	
	//
	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}	
	
	

}
