package modeles;

public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;

    //getter
    public Integer getDeptno() {
        return deptno;
    }
    public String getDname() {
        return dname;
    }
    public String getLoc() {
        return loc;
    }

    @Override
    public String toString() {
        return dname;
    }
}
