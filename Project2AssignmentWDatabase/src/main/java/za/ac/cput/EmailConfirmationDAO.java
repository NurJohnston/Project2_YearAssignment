package za.ac.cput;

import java.sql.*;


/**
 * EmailConfirmationApp.java
 * 222401680
 * @author Moegammad Nur Johnston
 * 2023/08/20
 */
public class EmailConfirmationDAO {
    private final String DB_URL = "jdbc:derby://localhost:1527/Applications";

    public void insertApplication(String course, String university) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO applications (course, university) VALUES (?, ?)")) {

            statement.setString(1, course);
            statement.setString(2, university);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
  

