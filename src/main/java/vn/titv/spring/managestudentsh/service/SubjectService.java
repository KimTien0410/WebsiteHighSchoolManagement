package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.SubjectDAO;
import vn.titv.spring.managestudentsh.entity.Subject;

import java.util.List;

@Service
public class SubjectService implements UtilService<Subject>{
    private SubjectDAO subjectDAO;
    @Autowired
    public SubjectService(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    @Override
    public List<Subject> getAll() {
        return this.subjectDAO.getAll();
    }

    @Override
    public Subject findById(int id) {
        return this.subjectDAO.findById(id);
    }

    @Override
    public void save(Subject Subject) {
        this.subjectDAO.save(Subject);
    }

    @Override
    public void update(Subject Subject) {
        this.subjectDAO.update(Subject);
    }

    @Override
    public void delete(Subject subject) {
        this.subjectDAO.delete(subject);
    }
}
