package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Classs;
import vn.titv.spring.managestudentsh.entity.Subject;

import java.util.List;

@Repository
@Transactional
public class SubjectDAO implements UtilDAO<Subject>{
    private EntityManager entityManager;
    @Autowired
    public SubjectDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Subject> getAll() {
        String jpql= "Select s from Subject s ";
        return this.entityManager.createQuery(jpql, Subject.class).getResultList();
    }

    @Override
    public void save(Subject subject) {
        this.entityManager.persist(subject);
    }

    @Override
    public Subject findById(int id) {
        return this.entityManager.find(Subject.class,id);
    }

    @Override
    public void update(Subject subject) {
        this.entityManager.merge(subject);
    }

    @Override
    public void delete(Subject subject) {
        this.entityManager.remove(subject);
    }
}
