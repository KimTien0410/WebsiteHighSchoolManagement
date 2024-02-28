package vn.titv.spring.managestudentsh.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.managestudentsh.entity.Classs;
import vn.titv.spring.managestudentsh.entity.Employee;

import java.util.List;

@Repository
@Transactional
public class EmployeeDAO implements UtilDAO<Employee>{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        String jpql= "Select s from Employee s ";
        return this.entityManager.createQuery(jpql, Employee.class).getResultList();
    }

    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }
}
