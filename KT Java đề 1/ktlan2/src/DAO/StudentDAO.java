/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author admin
 */
import POJO.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection;

    public StudentDAO() {
        try {
            // Replace with your database connection details
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=QuanLiLopHoc;user=sa;password=12;encrypt=true;trustServerCertificate=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            while (resultSet.next()) {
                Student student = new Student(
                    resultSet.getString("student_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("gender"),
                    resultSet.getString("country"),
                    resultSet.getString("city"),
                    resultSet.getInt("phone_number"),
                    resultSet.getDate("date_of_birth")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void addStudent(Student student) {
        try {
            String query = "INSERT INTO students (student_id, first_name, last_name, email, gender, country, city, phone_number, date_of_birth) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getStudentId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getGender());
            preparedStatement.setString(6, student.getCountry());
            preparedStatement.setString(7, student.getCity());
            preparedStatement.setInt(8, student.getPhoneNumber());
            preparedStatement.setDate(9, new java.sql.Date(student.getDateOfBirth().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        try {
            String query = "UPDATE students SET first_name = ?, last_name = ?, email = ?, gender = ?, country = ?, city = ?, phone_number = ?, date_of_birth = ? WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setString(5, student.getCountry());
            preparedStatement.setString(6, student.getCity());
            preparedStatement.setInt(7, student.getPhoneNumber());
            preparedStatement.setDate(8, new java.sql.Date(student.getDateOfBirth().getTime()));
            preparedStatement.setString(9, student.getStudentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String studentId) {
        try {
            String query = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}