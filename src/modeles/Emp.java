package modeles;

import java.time.LocalDate;

public class Emp {
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private LocalDate hiredate;
    private int sal;
    private int comm;
    private int deptno;


    //setter
    public void setComm(int comm) {
        this.comm = comm;
    }
    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
    }
    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
    public void setMgr(int mgr) {
        this.mgr = mgr;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    //getter
    public int getComm() {
        return comm;
    }
    public int getDeptno() {
        return deptno;
    }
    public int getEmpno() {
        return empno;
    }
    public String getEname() {
        return ename;
    }
    public LocalDate getHiredate() {
        return hiredate;
    }
    public String getJob() {
        return job;
    }
    public int getMgr() {
        return mgr;
    }
    public int getSal() {
        return sal;
    }

    @Override 
    public String toString() {
        return ename;
    }
}
