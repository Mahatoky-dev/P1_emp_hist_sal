import dao.ProjectDb;
import dao.exeption.DriverNotFoundExeption;
import modeles.Bonus;
import modeles.Dept;
import modeles.Emp;
import modeles.Hist_sal;
import modeles.Salgrade;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        try {
            ProjectDb projectDb = new ProjectDb();
            Emp emp = new Emp();
            Date date = Date.valueOf(LocalDate.of(2025, 4, 7));
            emp.setDeptno(99);
            // emp.setHiredate(date);
            emp.setComm(155);
            // emp.setEname("Manjaka");
            // emp.setJob("ETUD");
            // emp.setMgr(null);
            // emp.setSal(50);
            projectDb.startConnexion();
            //Date date = Date.valueOf(LocalDate.of(2025, 4, 3));
            ArrayList<String > atrWithSeq = new ArrayList<>();
            atrWithSeq.add("empno");
            System.out.println(projectDb.find(emp));
            projectDb.exit();
        } catch (DriverNotFoundExeption e) {
            e.printStackTrace();
        }
        
    }
}
