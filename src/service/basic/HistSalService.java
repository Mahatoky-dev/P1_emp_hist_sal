package service.basic;

import dao.ProjectDb;
import modeles.Hist_sal;
import service.Service;

public class HistSalService extends Service {

    public HistSalService(ProjectDb projectDb) {
        super(projectDb);
    }

    public Hist_sal[] getAllHistSal() {
        return getProjectDb().find(new Hist_sal()).toArray(new Hist_sal[0]);
    }
}
