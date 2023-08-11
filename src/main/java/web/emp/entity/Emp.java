package web.emp.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import web.dept.entity.Dept;

@Entity
public class Emp {

	@Id
	private Integer empno;
	private String ename;
	private String job;
	private String mgr;
	private Timestamp hiredate;
	private BigDecimal sal;
	private BigDecimal comm;
	private Integer deptno;
	
//	@ManyToOne
//	@JoinColumn(name = "DEPTNO", insertable = false, updatable = false)
//	private Dept dept;
	
	@ManyToOne
	@JoinColumn(name = "DEPTNO", insertable = false, updatable = false) //自方關聯用欄位
	private Dept dept;
	
	public Emp() {
		
	}
	
	public Emp(Integer empno, String ename, String job, String mgr, Timestamp hiredate, BigDecimal sal,
			BigDecimal comm, Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	public Timestamp getHiredate() {
		return hiredate;
	}
	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}
	public BigDecimal getSal() {
		return sal;
	}
	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}
	public BigDecimal getComm() {
		return comm;
	}
	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	
}
