package vn.titv.spring.managestudentsh.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="person_id")
    private Person person_employee;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,
           CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.PERSIST})
    @JoinColumn(name="notebook")
    private Notebook notebook;
    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="class_id")
    private Classs classs;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="subject_id")
    private Subject subject;

    public Employee() {
    }

    public Employee(int id,  Person person_employee, Notebook notebook, Classs classs) {
        this.id = id;
        this.person_employee = person_employee;
        this.notebook = notebook;
        this.classs = classs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Person getPerson_employee() {
        return person_employee;
    }

    public void setPerson_employee(Person person_employee) {
        this.person_employee = person_employee;
    }


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Classs getClasss() {
        return classs;
    }

    public void setClasss(Classs classs) {
        this.classs = classs;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeDetail=" + person_employee +
                ", notebook=" + notebook +
                ", classs=" + classs +
                '}';
    }
}
