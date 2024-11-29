import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/magazyn";
    private static final String USER = "root"; // Zmień na swoje dane logowania
    private static final String PASSWORD = "haslo"; // Zmień na swoje hasło

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
