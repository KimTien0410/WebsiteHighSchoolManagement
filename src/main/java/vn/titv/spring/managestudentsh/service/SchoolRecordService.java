package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.SchoolRecordDAO;
import vn.titv.spring.managestudentsh.entity.SchoolRecord;

import java.util.List;

@Service
public class SchoolRecordService implements UtilService<SchoolRecord>{
    private SchoolRecordDAO schoolRecordDAO;
    @Autowired

    public SchoolRecordService(SchoolRecordDAO schoolRecordDAO) {
        this.schoolRecordDAO = schoolRecordDAO;
    }

    @Override
    public List<SchoolRecord> getAll() {
        return this.schoolRecordDAO.getAll();
    }

    @Override
    public SchoolRecord findById(int id) {
        return this.schoolRecordDAO.findById(id);
    }

    @Override
    public void save(SchoolRecord schoolRecord) {
        this.schoolRecordDAO.save(schoolRecord);
    }


    @Override
    public void update(SchoolRecord schoolRecord) {
        this.schoolRecordDAO.update(schoolRecord);
    }

    @Override
    public void delete(SchoolRecord schoolRecord) {
        this.schoolRecordDAO.delete(schoolRecord);
    }
}
