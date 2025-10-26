package service.basic;

import java.util.ArrayList;

import dao.ProjectDb;
import modeles.Dept;
import service.Service;

public class DeptService extends Service {
    public DeptService(ProjectDb projectDb) {
        super(projectDb);
    }

    public Dept[] getAllDept(Dept filter) {
        ArrayList<Object> objEmp = getProjectDb().find(filter);
        return objEmp.toArray(new Dept[0]);
    }
}
