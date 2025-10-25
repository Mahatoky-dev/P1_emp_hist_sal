package dao;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.exeption.DbQueryErrorExeption;
import dao.exeption.DriverNotFoundExeption;

public class ProjectDb extends Db {

    private final String url = "jdbc:oracle:thin:@localhost:1521:EE";
    private final String user = "scott";
    private final String mdp = "scott";

    public ProjectDb() throws DriverNotFoundExeption {
        super(ORACLE_DEFAULD_DRIVER_NAME);
    }

    public void startConnexion() {
        try {
            this.connectTo(url, user, mdp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        try {
            this.stopConnexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // build query for emp with condition
    public String getSqlQueryFor(Object filter) {
        String sql = "select * from " + filter.getClass().getSimpleName().toUpperCase();
        Field[] fields = filter.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object fieldValue = field.get(filter);

                // ajouté les conditions specifique du filtre
                if (field.get((Object) filter) != null) {
                    if (!sql.contains("WHERE")) {
                        sql += " WHERE ";
                    } else {
                        sql += " AND ";
                    }

                    // ajouté la condition
                    String fieldName = field.getName();
                    sql += fieldName + "=" + fieldValue + " ";
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return sql;
    }

    public static Object instanceObjectFromResultSet(Class<?> class1, ResultSet rs) {
        try {
            Object obj = class1.newInstance();
            Field[] fields = class1.getDeclaredFields();

            // initialiser les valeurs de l'objet
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(obj,getFieldValueFromResultSet(field, rs));
            }
            return obj;

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getFieldValueFromResultSet(Field field, ResultSet rs) {

        try {
            Object value = null;
            String fieldName = field.getName();

            // instancer la valuer de l'atribut en fonction de sont type
            if (field.getType() == Integer.class) {
                value = rs.getInt(fieldName);
            } else if (field.getType() == String.class) {
                value = rs.getString(fieldName);
            } else if (field.getType() == Double.class) {
                value = rs.getDouble(fieldName);
            } else if (field.getType() == Boolean.class) {
                value = rs.getBoolean(fieldName);
            } else if (field.getType() == Date.class) {
                value = rs.getDate(fieldName);
            }

            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // prendre toute les employers
    public ArrayList<Object> find(Object filter){
        try {
            ArrayList<Object> employeList = new ArrayList<>();
            String sql = getSqlQueryFor(filter);
            ResultSet rs = this.executeQuery(sql);

            // instantier prendre le type recherché
            Class<?> class1 = Class.forName(filter.getClass().getName());
            while (rs.next()) {
                employeList.add(instanceObjectFromResultSet(class1, rs));
            }
            return employeList;

        } catch (DbQueryErrorExeption | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
