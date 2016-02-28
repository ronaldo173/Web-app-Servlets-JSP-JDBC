import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

/**
 * Created by Santer on 27.02.2016.
 */
public class StudentControllerServlet extends HttpServlet {

    private StudentDBUtil studentDBUtil;
    @Resource(name = "jdbc/webAppSJJ")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        //create student db util...pass in the conn pool/datasource

        try {
            studentDBUtil = new StudentDBUtil(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            listStudents(req, resp);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "error", e.toString(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        List<Student> students = studentDBUtil.getStudents();

        req.setAttribute("STUDENT_LIST", students);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(req, resp);

    }
}