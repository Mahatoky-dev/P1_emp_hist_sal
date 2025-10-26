package service;
import dao.ProjectDb;

public abstract class Service {
    private ProjectDb projectDb;

    public Service(ProjectDb projectDb) {
        this.projectDb = projectDb;
    }

    protected ProjectDb getProjectDb() {
        return projectDb;
    }
}
