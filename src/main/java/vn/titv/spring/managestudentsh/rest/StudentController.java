package vn.titv.spring.managestudentsh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.titv.spring.managestudentsh.entity.Student;
import vn.titv.spring.managestudentsh.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    @Autowired

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String getAllStudent(Model model){
        List<Student> students=studentService.getAll();
        model.addAttribute("students",students);
        return "/student/students";
    }
    @GetMapping("/create")
    public String add(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "/student/students-form";
    }
    @PostMapping("/save")
    public String add(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/student/list";
    }

}
