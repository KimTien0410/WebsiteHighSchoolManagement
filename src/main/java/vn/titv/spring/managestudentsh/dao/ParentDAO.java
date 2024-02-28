package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Classs;
import vn.titv.spring.managestudentsh.entity.Parent;

import java.util.List;

@Repository
@Transactional
public class ParentDAO implements UtilDAO<Parent> {
    private EntityManager entityManager;
    @Autowired
    public ParentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Parent> getAll() {
        String jpql= "Select s from Parent s ";
        return this.entityManager.createQuery(jpql, Parent.class).getResultList();
    }

    @Override
    public void save(Parent parent) {
        this.entityManager.persist(parent);

    }

    @Override
    public Parent findById(int id) {
        return this.entityManager.find(Parent.class,id);
    }

    @Override
    public void update(Parent parent) {
        this.entityManager.merge(parent);
    }

    @Override
    public void delete(Parent parent) {
        this.entityManager.remove(parent);
    }
}
