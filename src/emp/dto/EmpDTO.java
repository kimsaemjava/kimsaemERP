package emp.dto;

import java.sql.Date;

public class EmpDTO {
	
	private String id;
	private String pass;
	private String name;
	private String addr;
	private Date hiredate;
	private String grade;
	private int point;
	private String detpno;
	
	public EmpDTO(){
		
	}
	
	@Override
	public String toString() {
		return "EmpDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", addr=" + addr + ", hiredate=" + hiredate
				+ ", grade=" + grade + ", point=" + point + ", detpno=" + detpno + "]";
	}

	//삽입용
	public EmpDTO(String id, String pass, String name, String addr, String grade, int point, String detpno) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.grade = grade;
		this.point = point;
		this.detpno = detpno;
	}

	//조회용
	public EmpDTO(String id, String pass, String name, String addr, Date hiredate, String grade, int point,
			String detpno) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.hiredate = hiredate;
		this.grade = grade;
		this.point = point;
		this.detpno = detpno;
	}
	
	//업데이트용
	public EmpDTO(String id, String addr, String grade, int point
			) {
		super();
		this.id = id;
		this.addr = addr;
		this.grade = grade;
		this.point = point;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getDetpno() {
		return detpno;
	}

	public void setDetpno(String detpno) {
		this.detpno = detpno;
	}

}
