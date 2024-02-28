package vn.titv.spring.managestudentsh.service;

import vn.titv.spring.managestudentsh.dao.UtilDAO;

import java.util.List;

public interface UtilService<T> {
    public List<T> getAll();
    public T findById(int id);
     public void save(T t);
     public void update(T t);
     public void delete(T t);

}
