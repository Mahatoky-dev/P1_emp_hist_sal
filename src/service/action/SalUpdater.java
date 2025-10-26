package service.action;

import java.sql.Date;
import java.time.LocalDate;

import dao.ProjectDb;
import modeles.Emp;
import modeles.Hist_sal;

public class SalUpdater {
    private ProjectDb projectDb;

    public  SalUpdater(ProjectDb projectDb) {
        this.projectDb = projectDb;
    }

    public void updateSalEmp(Integer empno,Integer newSal) {
        //recuperation de l'employe
        Emp empFilter = new Emp();
        empFilter.setEmpno(empno);
        Object empObj = projectDb.find(empFilter).get(0);
        Emp emp = ((Emp)empObj);
        int pastSal = emp.getSal();

        //instantier l'emp avec une nouvelle val
        Emp empWithNewSal = new Emp();
        empWithNewSal.setSal(newSal);

        //instatiation de l'hist sal des l'ancienne salaire dans la base
        Hist_sal hist_sal = new Hist_sal(empno,Date.valueOf(LocalDate.now()),pastSal);
        if(this.projectDb.update(empFilter,empWithNewSal) != 0 && this.projectDb.insert(hist_sal) != 0) {
            System.out.println("Changement terminé");
        }
    }
}
