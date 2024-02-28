package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Classs;
import vn.titv.spring.managestudentsh.entity.School;

import java.util.List;

@Repository
@Transactional
public class SchoolDAO implements UtilDAO<School>{
    private EntityManager entityManager;
    @Autowired
    public SchoolDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<School> getAll() {
        String jpql= "Select s from School s ";
        return this.entityManager.createQuery(jpql, School.class).getResultList();
    }

    @Override
    public void save(School school) {
        entityManager.persist(school);
    }

    @Override
    public School findById(int id) {
        return entityManager.find(School.class,id);
    }

    @Override
    public void update(School school) {
        entityManager.merge(school);
    }

    public void delete(School school) {
        entityManager.remove(school);
    }
}
