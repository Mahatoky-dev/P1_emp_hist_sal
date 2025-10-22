package dao.exeption;

public class DriverNotFoundExeption extends ClassNotFoundException {
    public DriverNotFoundExeption(String driverName) {
        super("**DRIVER ' " + driverName + " '  NOT FOUND**");
    }
}