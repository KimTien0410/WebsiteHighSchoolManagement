package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.RoleDAO;
import vn.titv.spring.managestudentsh.entity.Role;

import java.util.List;

@Service
public class RoleService implements UtilService<Role>{
    private RoleDAO roleDAO;
    @Autowired
    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> getAll() {
        return this.roleDAO.getAll();
    }

    @Override
    public Role findById(int id) {
        return this.roleDAO.findById(id);
    }

    @Override
    public void save(Role role) {
        this.roleDAO.save(role);
    }

    @Override
    public void update(Role role) {
        this.roleDAO.update(role);
    }

    @Override
    public void delete(Role role) {
        this.roleDAO.delete(role);
    }

    public Role findByName(String name){
        return this.roleDAO.findByName(name);
    }
}
