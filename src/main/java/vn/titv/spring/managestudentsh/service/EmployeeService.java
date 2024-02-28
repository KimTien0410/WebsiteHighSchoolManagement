package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.EmployeeDAO;
import vn.titv.spring.managestudentsh.entity.Employee;

import java.util.List;

@Service
public class EmployeeService implements UtilService<Employee>{
    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeDAO.getAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeDAO.findById(id);
    }

    @Override
    public void save(Employee employee) {
        this.employeeDAO.save(employee);
    }

    @Override
    public void update(Employee employee) {
        this.employeeDAO.update(employee);
    }

    @Override
    public void delete(Employee employee) {
        this.employeeDAO.delete(employee);
    }
}
