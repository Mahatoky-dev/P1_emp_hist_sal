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
            //emp.setEmpno(100);
            // emp.setHiredate(date);
            //emp.setComm(155);
            // emp.setEname("Manjaka");
            // emp.setJob("ETUD");
            // emp.setMgr(null);
            emp.setDeptno(99);
            emp.setSal(50);
            projectDb.startConnexion();
            //Date date = Date.valueOf(LocalDate.of(2025, 4, 3));
            ArrayList<String > atrWithSeq = new ArrayList<>();
            atrWithSeq.add("empno");
            Emp salVal = new Emp();
            salVal.setSal(100);
            System.out.println(projectDb.update(emp,salVal));
            projectDb.exit();
        } catch (DriverNotFoundExeption e) {
            e.printStackTrace();
        }
        
    }
}
