package all;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santer on 27.02.2016.
 */
public class StudentDBUtil {

    private DataSource dataSource;

    public StudentDBUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Student> getStudents() throws Exception {
        List<Student> students = new ArrayList<>();
        String sql = "select * from student";

        try (
                Connection connection = dataSource.getConnection();
                java.sql.Statement statement = connection.createStatement()) {

            try (ResultSet resultSet = statement.executeQuery(sql)) {


                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_Name");
                    String lastName = resultSet.getString("last_Name");
                    String email = resultSet.getString("email");

                    Student student = new Student(id, firstName, lastName, email);

                    students.add(student);

                }
            }
        }

        return students;
    }

    public void addStudent(Student student) throws SQLException {
        System.out.println(student);
        String sql = "INSERT into STUDENT (first_name, last_name, email) values(?,?,?)";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEmail());

            preparedStatement.execute();
        }
    }
}

