package vn.titv.spring.managestudentsh.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="notebook")
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //Lớp học : OneToOne
    @OneToOne(mappedBy = "notebook",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Classs classs;
    //Teacher : OneToMany
    @OneToMany(mappedBy = "notebook",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    private List<Employee> employee;
    @Column(name="day_teaching")
    private Date dayTeaching;
    @Column(name="content")
    private String content;

    public Notebook() {
    }

    public Notebook(Classs classs, List<Employee> employee, Date dayTeaching, String content) {
        this.classs = classs;
        this.employee = employee;
        this.dayTeaching = dayTeaching;
        this.content = content;
    }

    public Notebook(int id, Classs classs, List<Employee> employee, Date dayTeaching, String content) {
        this.id = id;
        this.classs = classs;
        this.employee = employee;
        this.dayTeaching = dayTeaching;
        this.content = content;
    }

    public Notebook(Classs classs, Date dayTeaching, String content) {
        this.classs = classs;
        this.dayTeaching = dayTeaching;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Classs getClasss() {
        return classs;
    }

    public void setClasss(Classs classs) {
        this.classs = classs;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public Date getDayTeaching() {
        return dayTeaching;
    }

    public void setDayTeaching(Date dayTeaching) {
        this.dayTeaching = dayTeaching;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", classs=" + classs +
                ", employee=" + employee +
                ", dayTeaching=" + dayTeaching +
                ", content='" + content + '\'' +
                '}';
    }
}
