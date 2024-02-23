package service.student;

import config.ConnectionDB;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{
    private static final String INSERT_STUDENT = "insert into student(nameStudent, email, dateOfBirth, address, phone, id_class)" +
            "value (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_STUDENT = "select s.id_student, s.nameStudent, s.email, s.dateOfBirth, s.address, s.phone, c.nameClass \n" +
            "from student s join class c on s.id_class = c.id_class\n" +
            "where s.id_student = ?;";
    private static final String SELECT_ALL_STUDENT = "select s.id_student, s.nameStudent, s.email, s.dateOfBirth, s.address, s.phone, c.nameClass \n" +
            "from student s join class c on s.id_class = c.id_class;";
    private static final String DELETE_STUDENT = "delete from student where id_student = ?;";
    private static final String UPDATE_STUDENT = "update student set nameStudent = ?, email = ?, dayOfBirth = ?, address = ?, phone = ?, id_class = ? where id_student = ?;";
    public StudentDAO() {
    }
    Connection c = ConnectionDB.getConnection();

    @Override
    public void insertStudent(Student student) {
        System.out.println(INSERT_STUDENT);
        try {
            PreparedStatement statement = c.prepareStatement(INSERT_STUDENT);
            statement.setString(1, student.getNameStudent());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getDateOfBirth());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getPhone());
            statement.setString(6, student.getNameClass());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student selectStudent(int id_student) {
        Student student = null;
        try {
            PreparedStatement statement = c.prepareStatement(SELECT_STUDENT);
            statement.setInt(1, id_student);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                student = new Student();
                student.setId_student(resultSet.getInt("id_student"));
                student.setNameStudent(resultSet.getString("nameStudent"));
                student.setEmail(resultSet.getString("email"));
                student.setDateOfBirth(resultSet.getString("dateOfBirth"));
                student.setAddress(resultSet.getString("address"));
                student.setPhone(resultSet.getString("phone"));
                student.setNameClass(resultSet.getString("nameClass"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setId_student(resultSet.getInt("id_student"));
                student.setNameStudent(resultSet.getString("nameStudent"));
                student.setEmail(resultSet.getString("email"));
                student.setDateOfBirth(resultSet.getString("dateOfBirth"));
                student.setAddress(resultSet.getString("address"));
                student.setPhone(resultSet.getString("phone"));
                student.setNameClass(resultSet.getString("nameClass"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public void deleteStudent(int id_student) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(DELETE_STUDENT);
            statement.setInt(1, id_student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(Student student) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(UPDATE_STUDENT);
            statement.setString(1, student.getNameStudent());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getDateOfBirth());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getPhone());
            statement.setString(6, student.getNameClass());
            statement.setInt(7, student.getId_student());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void searchByName(Student nameStudent) {

    }
}
