import dao.ProjectDb;
import dao.exeption.DriverNotFoundExeption;
import modeles.Emp;

public class App {
    public static void main(String[] args) {

        try {
            ProjectDb projectDb = new ProjectDb();
            Emp emp = new Emp();
            emp.setDeptno(99);
            //System.out.println(projectDb.getSqlQueryFor(emp));
            projectDb.startConnexion();
            System.out.println(projectDb.find(emp));
            projectDb.exit();
        } catch (DriverNotFoundExeption e) {
            e.printStackTrace();
        }
        
    }
}
