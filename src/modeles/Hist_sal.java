package modeles;

import java.sql.Date;

public class Hist_sal {
    private Integer empno;
    private Date todate;
    private Integer sal;

    public Hist_sal() {

    }

    public Hist_sal(int empno,Date toDate,int sal) {
        this.empno = empno;
        this.todate = toDate;
        this.sal = sal;
    }

    public int getEmpno() {
        return empno;
    }
    public int getSal() {
        return sal;
    }
    public Date getTodate() {
        return todate;
    }

    @Override
    public String toString() {
        return empno.toString() + "   " +  todate.toString() + "    " + sal;
    }
}
