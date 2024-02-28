package vn.titv.spring.managestudentsh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.titv.spring.managestudentsh.service.StudentService;

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

        return "student/students";
    }
}
