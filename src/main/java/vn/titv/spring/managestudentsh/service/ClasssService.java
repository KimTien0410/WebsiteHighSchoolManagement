package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.ClasssDAO;
import vn.titv.spring.managestudentsh.entity.Classs;

import java.util.List;

@Service
public class ClasssService implements UtilService<Classs>{
    private ClasssDAO classsDAO;
    @Autowired
    public ClasssService(ClasssDAO classsDAO) {
        this.classsDAO = classsDAO;
    }

    @Override
    public List<Classs> getAll() {
        return this.classsDAO.getAll();
    }

    @Override
    public Classs findById(int id) {
        return this.classsDAO.findById(id);
    }

    @Override
    public void save(Classs classs) {
        this.classsDAO.save(classs);
    }

    @Override
    public void update(Classs classs) {
        this.classsDAO.update(classs);
    }

    @Override
    public void delete(Classs classs) {
        this.classsDAO.delete(classs);
    }
}
