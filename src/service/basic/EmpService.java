package service.basic;

import java.util.ArrayList;

import dao.ProjectDb;
import modeles.Emp;
import service.Service;

public class EmpService extends Service{

    public  EmpService(ProjectDb projectDb) {
        super(projectDb);
    }

    public Emp[] getAllEmp(Emp filter) {
        ArrayList<Object> objEmp = getProjectDb().find(filter);
        return objEmp.toArray(new Emp[0]);
    }
}
