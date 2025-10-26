package service.basic;

import dao.ProjectDb;
import modeles.Hist_sal;
import modeles.Salgrade;
import service.Service;

public class SalgradeService extends Service {
    public SalgradeService(ProjectDb projectDb) {
        super(projectDb);
    }

    public Salgrade[] getAllSalgrade(Salgrade filter) {
        return getProjectDb().find(new Hist_sal()).toArray(new Salgrade[0]);
    }
}
