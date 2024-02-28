package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Classs;
import vn.titv.spring.managestudentsh.entity.Person;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@Transactional
public class PersonDAO implements UtilDAO<Person>{
    private EntityManager entityManager;
    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> getAll() {
        String jpql= "Select s from Person s ";
        return this.entityManager.createQuery(jpql, Person.class).getResultList();
    }

    @Override
    public void save(Person person) {
        this.entityManager.persist(person);

    }

    @Override
    public Person findById(int id) {
        return this.entityManager.find(Person.class,id);
    }

    @Override
    public void update(Person person) {
        this.entityManager.merge(person);
    }

    @Override
    public void delete(Person person) {
        this.entityManager.remove(person);
    }

  /*  public Person findByUsername(String username){
        String jpql="Select p From Person p where p.username=:u";
        TypedQuery<Person> query=this.entityManager.createQuery(jpql,Person.class);
        query.setParameter("u",username);
        return query.getSingleResult();

    }*/
}
