package modeles;

public class Salgrade {

    private Integer grade;
    private Integer losal;
    private Integer hisal;

    public Integer getGrade() {
        return grade;
    }

    public Integer getHisal() {
        return hisal;
    }

    public Integer getLosal() {
        return losal;
    }

    @Override
    public String toString() {
        return this.grade.toString();
    }
}