package ua.lviv.iot.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionManager {

    private static final String URL =
            "jdbc:mysql://localhost:3306/shcherba?serverTimezone=UTC"
                    + "&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";

    private static Connection CONNECTION;

    public ConnectionManager() {

    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            if (CONNECTION == null ||
                    CONNECTION.isClosed()) {
                try {
                    CONNECTION = DriverManager
                            .getConnection(URL, USER, PASSWORD);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return CONNECTION;
    }

}
