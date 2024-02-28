package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.PersonDAO;
import vn.titv.spring.managestudentsh.entity.Person;

import java.util.List;

@Service
public class PersonService implements UtilService<Person> {
    private PersonDAO personDAO;
    @Autowired
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public List<Person> getAll() {
        return this.personDAO.getAll();
    }

    @Override
    public Person findById(int id) {
        return this.personDAO.findById(id);
    }

    @Override
    public void save(Person person) {
        this.personDAO.save(person);
    }

    @Override
    public void update(Person person) {
        this.personDAO.update(person);
    }

    @Override
    public void delete(Person person) {
        this.personDAO.delete(person);
    }



}
