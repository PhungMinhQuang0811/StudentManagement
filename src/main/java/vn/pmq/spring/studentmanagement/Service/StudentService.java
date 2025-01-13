package vn.pmq.spring.studentmanagement.Service;

import vn.pmq.spring.studentmanagement.Model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public Student findById(int id);
    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public Student findByAccountId(int accountId);
}
