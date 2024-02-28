package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Classs;
import vn.titv.spring.managestudentsh.entity.SchoolRecord;

import java.util.List;

@Repository
@Transactional
public class SchoolRecordDAO implements UtilDAO<SchoolRecord>{
    private EntityManager entityManager;
    @Autowired
    public SchoolRecordDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<SchoolRecord> getAll() {
        String jpql= "Select s from SchoolRecord s ";
        return this.entityManager.createQuery(jpql, SchoolRecord.class).getResultList();
    }

    @Override
    public void save(SchoolRecord schoolRecord) {
        this.entityManager.persist(schoolRecord);
    }

    @Override
    public SchoolRecord findById(int id) {
        return this.entityManager.find(SchoolRecord.class,id);
    }

    @Override
    public void update(SchoolRecord schoolRecord) {
        this.entityManager.merge(schoolRecord);
    }

    @Override
    public void delete(SchoolRecord schoolRecord) {
        this.entityManager.remove(schoolRecord);
    }
}
