package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Classs;
import vn.titv.spring.managestudentsh.entity.Role;

import java.util.List;

@Repository
@Transactional

public class RoleDAO implements UtilDAO<Role>{
    private EntityManager entityManager;
    @Autowired
    public RoleDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Role> getAll() {
        String jpql= "Select s from Role s ";
        return this.entityManager.createQuery(jpql, Role.class).getResultList();
    }

    @Override
    public void save(Role role) {
        this.entityManager.persist(role);

    }

    @Override
    public Role findById(int id) {
        return this.entityManager.find(Role.class,id);
    }


    @Override
    public void update(Role role) {
        this.entityManager.merge(role);

    }

    @Override
    public void delete(Role role) {
        this.entityManager.remove(role);
    }

    public Role findByName(String name){
        String jpql="Select r From Role r where r.name=:n";
        TypedQuery<Role> query=this.entityManager.createQuery(jpql,Role.class);
        return query.getSingleResult();
    }
}
