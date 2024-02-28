package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Classs;
import vn.titv.spring.managestudentsh.entity.Scoreboard;

import java.util.List;

@Repository
@Transactional
public class ScoreboardDAO implements UtilDAO<Scoreboard>{
    private EntityManager entityManager;
    @Autowired
    public ScoreboardDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Scoreboard> getAll() {
        String jpql= "Select s from Scoreboard s ";
        return this.entityManager.createQuery(jpql, Scoreboard.class).getResultList();
    }

    @Override
    public void save(Scoreboard scoreboard) {
        this.entityManager.persist(scoreboard);
    }

    @Override
    public Scoreboard findById(int id) {
        return this.entityManager.find(Scoreboard.class,id);
    }

    @Override
    public void update(Scoreboard scoreboard) {
        this.entityManager.merge(scoreboard);
    }

    @Override
    public void delete(Scoreboard scoreboard) {
        this.entityManager.remove(scoreboard);
    }
}
