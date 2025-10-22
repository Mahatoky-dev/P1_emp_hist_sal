package dao;
import java.sql.*;

import dao.exeption.DbQueryErrorExeption;
import dao.exeption.DriverNotFoundExeption;

public class Db {

    // Le driver de la connexion
    private String driver;

    // propriété des requetes
    private Connection con;
    private Statement st;

    public final static String ORACLE_DEFAULD_DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

    public Db(String driver) throws DriverNotFoundExeption {
        this.driver = driver;
        initDriver(driver);
    }

    private void initDriver(String driverName) throws DriverNotFoundExeption {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new DriverNotFoundExeption(driverName);
        }
    }

    protected void connectTo(String url, String user, String passwd) throws SQLException {
        this.con = DriverManager.getConnection(url, user, passwd);
        this.st = con.createStatement();
    }

    protected ResultSet executeQuery(String sqlQuery) throws DbQueryErrorExeption ,SQLException {
        if(con == null) {
            throw new DbQueryErrorExeption("Connexion is not init");
        }

        //execution de la requete
        return this.st.executeQuery(sqlQuery);
    }

    protected int executeUpdate(String sql) throws SQLException {
        return this.st.executeUpdate(sql);
    }

    protected void stopConnexion() throws SQLException {
        con.close();
    }
}