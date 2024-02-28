package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.SchoolDAO;
import vn.titv.spring.managestudentsh.entity.School;

import java.util.List;

@Service
public class SchoolService implements UtilService<School>{
    private SchoolDAO schoolDAO;
    @Autowired

    public SchoolService(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    @Override
    public List<School> getAll() {
        return this.schoolDAO.getAll();
    }

    @Override
    public School findById(int id) {
        return this.schoolDAO.findById(id);
    }

    @Override
    public void save(School school) {
        this.schoolDAO.save(school);
    }


    @Override
    public void update(School school) {
        this.schoolDAO.update(school);
    }

    @Override
    public void delete(School school) {
        this.schoolDAO.delete(school);
    }
}
