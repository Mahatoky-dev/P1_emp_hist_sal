package service.filter;

import java.util.ArrayList;
import java.util.HashMap;

import dao.ProjectDb;
import modeles.Emp;
import modeles.Hist_sal;
import service.Service;
import service.basic.EmpService;
import service.basic.HistSalService;

import java.sql.Date;
import java.time.temporal.ChronoUnit;

public class EmpHistSalFilter extends Service {

    public EmpHistSalFilter(ProjectDb projectDb) {
        super(projectDb);
    }

    public HashMap<Emp, Integer> getSalEmpOn(Date t) {
        HashMap<Emp, Integer> empSalList = new HashMap<>();

        EmpService empService = new EmpService(getProjectDb());
        HistSalService histSalService = new HistSalService(getProjectDb());

        // liste de toute les employer et les historique de sal
        Emp[] emps = empService.getAllEmp(new Emp());
        Hist_sal[] hist_sals = histSalService.getAllHistSal();

        // chercher le salaire corespendente pour un emp a une date t
        for (Emp emp : emps) {
            int empSal = -1;
            long day = 10_000_000;

            for (Hist_sal hist_sal : hist_sals) {
                long t_to_hist_day = ChronoUnit.DAYS.between(t.toLocalDate(), hist_sal.getTodate().toLocalDate());

                if (emp.getEmpno() == hist_sal.getEmpno()
                        && (hist_sal.getTodate().after(t) || hist_sal.getTodate().equals(t))
                        && t_to_hist_day < day) {
                    day = t_to_hist_day;
                    empSal = hist_sal.getSal();
                }
            }
            if (empSal == -1) {
                empSalList.put(emp, emp.getSal());
            } else {
                empSalList.put(emp, empSal);
            }
        }

        return empSalList;
    }
}