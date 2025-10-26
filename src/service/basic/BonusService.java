package service.basic;

import java.util.ArrayList;

import dao.ProjectDb;
import modeles.Bonus;
import service.Service;

public class BonusService extends Service{

    public  BonusService(ProjectDb projectDb) {
        super(projectDb);
    }

    public Bonus[] getAllBonus(Bonus filter) {
        ArrayList<Object> objBonus = getProjectDb().find(filter);
        return objBonus.toArray(new Bonus[0]);
    }
}
