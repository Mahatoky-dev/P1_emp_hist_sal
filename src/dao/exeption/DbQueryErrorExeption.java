package dao.exeption;

public class DbQueryErrorExeption extends Exception {
    
    public DbQueryErrorExeption(String msg) {
        super(msg);
    }
}
