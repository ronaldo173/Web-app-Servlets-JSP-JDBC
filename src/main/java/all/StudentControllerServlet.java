package all;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/StudentControllerServlet")
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
            //read parameter
            String theCommand = req.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }

            switch (theCommand) {
                case "LIST":
                    listStudents(req, resp);
                    break;
                case "ADD":
                    addStudent(req, resp);
                    break;
                case "LOAD":
                    loadStudent(req, resp);
                default:
                    listStudents(req, resp);

            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString(), "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String studentId = req.getParameter("studentId");
        Student student = studentDBUtil.getStudent(studentId);
        req.setAttribute("THE_STUDENT", student);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/update-student-form.jsp");
        dispatcher.forward(req, resp);
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        Student student = new Student(firstName, lastName, email);
        studentDBUtil.addStudent(student);

        //send back to main page
        listStudents(req, resp);
    }

    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        List<Student> students = studentDBUtil.getStudents();

        req.setAttribute("STUDENT_LIST", students);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(req, resp);

    }
}
