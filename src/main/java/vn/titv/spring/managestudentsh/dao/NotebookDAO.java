package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Classs;
import vn.titv.spring.managestudentsh.entity.Notebook;

import java.util.List;

@Repository
@Transactional
public class NotebookDAO implements UtilDAO<Notebook>{
    private EntityManager entityManager;

    public NotebookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Notebook> getAll() {
        String jpql= "Select s from Notebook s ";
        return this.entityManager.createQuery(jpql, Notebook.class).getResultList();
    }

    @Override
    public void save(Notebook notebook) {
        this.entityManager.persist(notebook);
    }

    @Override
    public Notebook findById(int id) {
        return this.entityManager.find(Notebook.class,id);
    }

    @Override
    public void update(Notebook notebook) {
        this.entityManager.merge(notebook);
    }

    @Override
    public void delete(Notebook notebook) {
        this.entityManager.remove(notebook);
    }
}
