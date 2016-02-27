package testSmth;

import java.sql.*;

/**
 * Created by Santer on 27.02.2016.
 */
public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp", "root", "root");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT  * from student");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("email"));

        }
        connection.close();

    }
}
