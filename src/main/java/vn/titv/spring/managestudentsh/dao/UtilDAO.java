package vn.titv.spring.managestudentsh.dao;

import java.util.List;
import java.util.Optional;

public interface UtilDAO<T> {
    public List<T> getAll();
    public void save(T t);
    public T findById(int id);
    public void update(T t);
    public void delete(T t);

}
