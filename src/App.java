import dao.ProjectDb;
import dao.exeption.DriverNotFoundExeption;
import modeles.Bonus;
import modeles.Dept;
import modeles.Emp;
import modeles.Hist_sal;
import modeles.Salgrade;
import java.sql.Date;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        try {
            ProjectDb projectDb = new ProjectDb();
            Emp emp = new Emp();
            emp.setDeptno(99);
            emp.setHiredate(Date.valueOf(LocalDate.of(2025, 4, 4)));
            projectDb.startConnexion();
            //Date date = Date.valueOf(LocalDate.of(2025, 4, 3));
            System.out.println(projectDb.getQueryInsert(emp));
            projectDb.exit();
        } catch (DriverNotFoundExeption e) {
            e.printStackTrace();
        }
        
    }
}
