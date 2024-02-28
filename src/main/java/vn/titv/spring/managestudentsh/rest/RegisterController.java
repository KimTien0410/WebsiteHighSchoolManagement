package vn.titv.spring.managestudentsh.rest;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import vn.titv.spring.managestudentsh.entity.*;
import vn.titv.spring.managestudentsh.service.*;
import vn.titv.spring.managestudentsh.web.Register;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private AccountService accountService;
    private RoleService roleService;
    private PersonService personService;
    private EmployeeService employeeService;
    private StudentService studentService;
    @Autowired
    public RegisterController(AccountService accountService, RoleService roleService, PersonService personService, EmployeeService employeeService, StudentService studentService) {
        this.accountService = accountService;
        this.roleService = roleService;
        this.personService = personService;
        this.employeeService = employeeService;
        this.studentService = studentService;
    }

    @GetMapping("/showRegisterPage")
    public String showRegisterPage(Model model){
        Register register=new Register();
        model.addAttribute("register",register);
        model.addAttribute("roles",this.roleService.getAll());
        return "register/form";
    }
    public  void InitBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @PostMapping("/process")
    public String Process(@Valid @ModelAttribute Register register, BindingResult result, Model model,
                          HttpSession session){
        String username=register.getUsername();
        //form validation
        if(result.hasErrors()){
            return "register/form";
        }
        //check account da ton tai
        Account account1=accountService.findByUsername(username);
        if(account1 !=null){
            model.addAttribute("register",new Register());
            model.addAttribute("my_error","Username is existed");
            return "/register/form";
        }
        //Neu chua ton tai thi luu xuong db
        BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
        Account account=new Account();
        account.setUsername(register.getUsername());
        account.setPassword(bcrypt.encode(register.getPassword()));

        List<Role> roles=new ArrayList<>();
        roles.add(this.roleService.findByName(register.getRole()));
        account.setRoles(roles);

        Person person=new Person();
        person.setFullName(register.getFullName());
        person.setGender(register.getGender());
        person.setDayOfBirth(register.getDateOfBirth());
        person.setEmail(register.getEmail());

        if(register.getRole().equals("ROLE_STUDENT")){
            Student student=new Student();
            person.setStudent(student);
        }
        else if(register.getRole().equals("ROLE_EMPLOYEE")){
            Employee employee=new Employee();
            person.setEmployee(employee);
        }
        personService.save(person);
        //Thong bao thanh cong
        session.setAttribute("myperson",person);

        return "register/confirmation";
    }

}
