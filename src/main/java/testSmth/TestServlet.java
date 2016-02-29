package testSmth;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * Created by Santer on 27.02.2016.
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Resource(name = "jdbc/webAppSJJ")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            Class.forName("com.mysql.jdbc.Driver");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from student");
            writer.println();

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                writer.println();
                writer.print(email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);

    }
}
