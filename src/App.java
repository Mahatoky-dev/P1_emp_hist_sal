import dao.ProjectDb;
import dao.exeption.DriverNotFoundExeption;

public class App {
    public static void main(String[] args) {
        try {
            ProjectDb projectDb = new ProjectDb();
            projectDb.startConnexion();
            System.out.println(projectDb.findEmp(null));
            projectDb.exit();
        } catch (DriverNotFoundExeption e) {
            e.printStackTrace();
        }
        
    }
}
