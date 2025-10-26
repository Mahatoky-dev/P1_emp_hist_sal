import dao.ProjectDb;
import dao.exeption.DriverNotFoundExeption;
import modeles.Bonus;
import modeles.Dept;
import modeles.Emp;
import modeles.Hist_sal;
import modeles.Salgrade;
import service.action.SalUpdater;
import service.basic.EmpService;
import service.filter.EmpHistSalFilter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        try {
            ProjectDb projectDb = new ProjectDb();
            Emp emp = new Emp();
            Date date = Date.valueOf(LocalDate.of(2025, 4, 7));
            //emp.setEmpno(7);
            // emp.setHiredate(date);
            // emp.setComm(155);
            // emp.setEname("Manjaka");
            // emp.setJob("ETUD");
            // emp.setMgr(null);
            //emp.setDeptno(90);
            //emp.setSal(1500);
            projectDb.startConnexion();
            // Date date = Date.valueOf(LocalDate.of(2025, 4, 3));
            //Emp salVal = new Emp();
            //salVal.setSal(900);
            //System.out.println(projectDb.update(emp,salVal));
            //SalUpdater salUpdater = new SalUpdater(projectDb);
            //salUpdater.updateSalEmp(7,1000);

            EmpHistSalFilter empHistSalFilter = new EmpHistSalFilter(projectDb);
            EmpService empService = new EmpService(projectDb);
            for (Map.Entry<Emp, Integer> empSal : empHistSalFilter.getSalEmpOn(Date.valueOf(LocalDate.of(2021, 02, 2)))
                    .entrySet()) {
                         if(empSal.getKey().getEmpno() == 9001) {
                            System.out.println(empSal.getKey() + " : " + empSal.getValue());
                        }
            }
            
            projectDb.exit();
        } catch (DriverNotFoundExeption e) {
            e.printStackTrace();
        }

    }
}
