package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Classs;

import java.util.List;

@Repository
@Transactional
public class ClasssDAO implements UtilDAO<Classs>{
    private EntityManager entityManager;
    @Autowired
    public ClasssDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Classs> getAll() {
        String jpql= "Select s from Classs s ";
        return this.entityManager.createQuery(jpql,Classs.class).getResultList();
    }

    @Override
    public void save(Classs classs) {
        entityManager.persist(classs);
    }

    @Override
    public Classs findById(int id) {
        return entityManager.find(Classs.class,id);
    }

    @Override
    public void update(Classs classs) {
        entityManager.merge(classs);
    }

    @Override
    public void delete(Classs classs) {
        entityManager.remove(classs);
    }
}
