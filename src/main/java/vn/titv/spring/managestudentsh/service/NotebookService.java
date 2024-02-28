package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.NotebookDAO;
import vn.titv.spring.managestudentsh.entity.Notebook;

import java.util.List;

@Service
public class NotebookService implements UtilService<Notebook>{
    private NotebookDAO notebookDAO;
    @Autowired
    public NotebookService(NotebookDAO notebookDAO) {
        this.notebookDAO = notebookDAO;
    }

    @Override
    public List<Notebook> getAll() {
        return this.notebookDAO.getAll();
    }

    @Override
    public Notebook findById(int id) {
        return this.notebookDAO.findById(id);
    }

    @Override
    public void save(Notebook notebook) {
        this.notebookDAO.save(notebook);
    }

    @Override
    public void update(Notebook notebook) {
        this.notebookDAO.update(notebook);
    }

    @Override
    public void delete(Notebook notebook) {
        this.notebookDAO.delete(notebook);
    }
}
