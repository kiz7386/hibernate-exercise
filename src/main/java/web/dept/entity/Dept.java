package web.dept.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import web.emp.entity.Emp;

@Entity
public class Dept {

	@Id
	private Integer deptno;
	private String dname;
	private String loc;
	
//	@OneToMany
//	@JoinColumn(name = "DEPTNO", referencedColumnName = "DEPTNO") // 要看db的欄位
//	private List<Emp> emps;
	
	
	@OneToMany(mappedBy = "dept") //在對方實體類別內，用來關聯自方的屬性名
	private List<Emp> emps;
	
	
	public Dept() {
		
	}
	
	public Dept(Integer deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
	
	
}
