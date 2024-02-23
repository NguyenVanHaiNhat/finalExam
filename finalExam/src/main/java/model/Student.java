package model;

public class Student extends Class{
    private int id_student;
    private String nameStudent;
    private String email;
    private String dateOfBirth;
    private String address;
    private String phone;
    private int idClass;

    public Student() {
    }

    public Student(int id_student, String nameStudent, String email, String dateOfBirth, String address, String phone, int idClass) {
        this.id_student = id_student;
        this.nameStudent = nameStudent;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.idClass = idClass;
    }

    public Student(String nameStudent, String email, String dateOfBirth, String address, String phone, String nameClass) {
        this.nameStudent = nameStudent;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.setNameClass(nameClass);
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int getIdClass() {
        return idClass;
    }

    @Override
    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }
}
