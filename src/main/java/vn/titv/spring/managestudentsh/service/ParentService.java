package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.ParentDAO;
import vn.titv.spring.managestudentsh.entity.Parent;

import java.util.List;

@Service
public class ParentService implements UtilService<Parent>{
    private ParentDAO parentDAO;
    @Autowired
    public ParentService(ParentDAO parentDAO) {
        this.parentDAO = parentDAO;
    }

    @Override
    public List<Parent> getAll() {
        return this.parentDAO.getAll();
    }

    @Override
    public Parent findById(int id) {
        return this.parentDAO.findById(id);
    }

    @Override
    public void save(Parent parent) {
        this.parentDAO.save(parent);
    }

    @Override
    public void update(Parent parent) {
        this.parentDAO.update(parent);
    }

    @Override
    public void delete(Parent parent) {
        this.parentDAO.delete(parent);
    }
}
