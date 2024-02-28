package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Classs;
import vn.titv.spring.managestudentsh.entity.Student;

import java.util.List;

@Repository
@Transactional
public class StudentDAO implements UtilDAO<Student>{
    private EntityManager entityManager;
    @Autowired
    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAll() {
        String jpql= "Select s from Student s ";
        return this.entityManager.createQuery(jpql, Student.class).getResultList();
    }

    @Override
    public void save(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return this.entityManager.find(Student.class,id);
    }

    @Override
    public void update(Student student) {
        this.entityManager.merge(student);
    }

    @Override
    public void delete(Student student) {
        this.entityManager.remove(student);
    }
}
