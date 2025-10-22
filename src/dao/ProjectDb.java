package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dao.exeption.DbQueryErrorExeption;
import dao.exeption.DriverNotFoundExeption;
import modeles.Emp;

public class ProjectDb extends Db {

    private final String url = "jdbc:oracle:thin:@localhost:1521:EE";
    private final String user = "scott";
    private final String mdp = "scott";
    public ProjectDb() throws DriverNotFoundExeption {
        super(ORACLE_DEFAULD_DRIVER_NAME);
    }

    public void startConnexion() {
        try {
            this.connectTo(url,user,mdp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        try {
            this.stopConnexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //prendre toute les employers
    public ArrayList<Emp> findEmp(Emp emp) {
        try {
            ArrayList<Emp> employeList = new ArrayList<>();
            String sql = "SELECT * FROM EMP";
            ResultSet rs = this.executeQuery(sql);
            
            while(rs.next()) {
                Emp employe = new Emp();
                employe.setEmpno(rs.getInt("empno"));
                employe.setEname(rs.getString("ename"));
                employe.setJob("job");
                employe.setMgr(rs.getInt("mgr"));
                employe.setHiredate(LocalDate.now());
                employe.setSal(rs.getInt("sal"));
                employe.setComm(rs.getInt("comm"));
                employe.setDeptno(rs.getInt("deptno"));

                employeList.add(employe);
            }
            return employeList;

        } catch (DbQueryErrorExeption | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
