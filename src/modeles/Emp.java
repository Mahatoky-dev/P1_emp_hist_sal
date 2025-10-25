package modeles;

import java.sql.Date;

public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Integer sal;
    private Integer comm;
    private Integer deptno;


    //setter
    public void setComm(Integer comm) {
        this.comm = comm;
    }
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }
    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }
    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }

    //getter
    public Integer getComm() {
        return comm;
    }
    public Integer getDeptno() {
        return deptno;
    }
    public Integer getEmpno() {
        return empno;
    }
    public String getEname() {
        return ename;
    }
    public Date getHiredate() {
        return hiredate;
    }
    public String getJob() {
        return job;
    }
    public Integer getMgr() {
        return mgr;
    }
    public Integer getSal() {
        return sal;
    }

    @Override 
    public String toString() {
        return ename;
    }
}
