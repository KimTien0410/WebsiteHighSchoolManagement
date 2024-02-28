package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Classs;
import vn.titv.spring.managestudentsh.entity.Scorecard;

import java.util.List;

@Repository
@Transactional
public class ScorecardDAO implements UtilDAO<Scorecard>{
    private EntityManager entityManager;
    @Autowired
    public ScorecardDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Scorecard> getAll() {
        String jpql= "Select s from Scorecard s ";
        return this.entityManager.createQuery(jpql, Scorecard.class).getResultList();
    }

    @Override
    public void save(Scorecard scorecard) {
        this.entityManager.persist(scorecard);
    }

    @Override
    public Scorecard findById(int id) {
        return this.entityManager.find(Scorecard.class, id);
    }

    @Override
    public void update(Scorecard scorecard) {
        this.entityManager.merge(scorecard);
    }

    @Override
    public void delete(Scorecard scorecard) {
        this.entityManager.remove(scorecard);
    }
}
