package vn.titv.spring.managestudentsh.service;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.AccountDAO;
import vn.titv.spring.managestudentsh.entity.Account;
import vn.titv.spring.managestudentsh.entity.Role;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService implements UtilService<Account>, UserDetailsService {
    private AccountDAO accountDAO;
    @Autowired
    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Account> getAll() {
        return this.accountDAO.getAll();
    }

    @Override
    public Account findById(int id) {
        return this.accountDAO.findById(id);
    }

    @Override
    public void save(Account account) {
        this.accountDAO.save(account);
    }

    @Override
    public void update(Account account) {
        this.accountDAO.save(account);
    }

    @Override
    public void delete(Account account) {
        this.accountDAO.delete(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account=this.accountDAO.findByUsername(username);
        if(account==null){
            throw  new UsernameNotFoundException("Invalid username or password") ;
        }
        return new org.springframework.security.core.userdetails.User(account.getUsername(),account.getPassword(),rolesToAuthorities(account.getRoles()));
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
