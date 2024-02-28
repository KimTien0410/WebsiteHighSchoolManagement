package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Account;

import java.util.List;

@Repository
@Transactional
public class AccountDAO implements UtilDAO<Account>{
    private EntityManager entityManager;
    @Autowired
    public AccountDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Account> getAll() {
        String jpql="Select a From Account a ";
        return this.entityManager.createQuery(jpql,Account.class).getResultList();
    }

    @Override
    public void save(Account account) {
        this.entityManager.persist(account);
    }

    @Override
    public Account findById(int id) {
        return this.entityManager.find(Account.class, id);
    }

    @Override
    public void update(Account account) {
        this.entityManager.merge(account);
    }

    @Override
    public void delete(Account account) {
        this.entityManager.remove(account);
    }

    public Account findByUsername(String username){
        String jpql="Select a from Account a where a.username= :username";
        TypedQuery<Account> query=this.entityManager.createQuery(jpql,Account.class);
        query.setParameter("username",username);
        return query.getSingleResult();
    }
}
