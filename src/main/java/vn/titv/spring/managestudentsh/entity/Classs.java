package vn.titv.spring.managestudentsh.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name_class")
    private String nameClass;
    @Column(name="grade")
    private String grade;
    @Column(name="school_year")
    private String schoolYear;
    @OneToOne(mappedBy = "classs",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Employee employee_CN;
    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="notebook_id")
    private Notebook notebook;

   @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Student> students;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name="school_id")
    private School school;

    public Class() {
    }

    public Class(String nameClass, String grade, String schoolYear, Employee employee_CN, Notebook notebook, List<Student> students, School school) {
        this.nameClass = nameClass;
        this.grade = grade;
        this.schoolYear = schoolYear;
        this.employee_CN = employee_CN;
        this.notebook = notebook;
        this.students = students;
        this.school = school;
    }

    public Class(String nameClass, String grade, String schoolYear) {
        this.nameClass = nameClass;
        this.grade = grade;
        this.schoolYear = schoolYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Employee getEmployee_CN() {
        return employee_CN;
    }

    public void setEmployee_CN(Employee employee_CN) {
        this.employee_CN = employee_CN;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", nameClass='" + nameClass + '\'' +
                ", grade='" + grade + '\'' +
                ", schoolYear='" + schoolYear + '\'' +
                ", employee_CN=" + employee_CN +
                ", notebook=" + notebook +
                ", students=" + students +
                ", school=" + school +
                '}';
    }
}
