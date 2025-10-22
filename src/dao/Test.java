package dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.exeption.DbQueryErrorExeption;
import dao.exeption.DriverNotFoundExeption;

public class Test {
    public static void main(String[] args) {
        
        try {
            Db db = new Db(Db.ORACLE_DEFAULD_DRIVER_NAME);
            db.connectTo("jdbc:oracle:thin:@localhost:1521:EE", "scott","scott");

            ResultSet rs = db.executeQuery("SELECT * FROM EMP");

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (DriverNotFoundExeption | SQLException | DbQueryErrorExeption  e) {
            
            e.printStackTrace();
        }
    }    
}
