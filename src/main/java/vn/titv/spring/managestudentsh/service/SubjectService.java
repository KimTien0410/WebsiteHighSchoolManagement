package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.StudentDAO;
import vn.titv.spring.managestudentsh.entity.Student;

@Service
public class StudentService implements UtilService<Student>{
    private StudentDAO studentDAO;
    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Student findById(int id) {
        return this.studentDAO.findById(id);
    }

    @Override
    public void save(Student student) {
        this.studentDAO.save(student);
    }

    @Override
    public void update(Student student) {
        this.studentDAO.update(student);
    }

    @Override
    public void delete(Student student) {
        this.studentDAO.delete(student);
    }
}
