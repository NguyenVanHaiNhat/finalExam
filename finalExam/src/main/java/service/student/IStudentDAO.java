package service.student;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    void insertStudent(Student student) throws SQLException;
    Student selectStudent(int id_student);
    List<Student> selectAllStudent();
    void deleteStudent(int id_student) throws SQLException;
    void updateStudent(Student student) throws SQLException;
    void searchByName(Student nameStudent) throws SQLException;
}
