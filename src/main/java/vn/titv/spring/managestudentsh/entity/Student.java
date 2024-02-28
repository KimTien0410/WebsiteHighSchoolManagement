package vn.titv.spring.managestudentsh.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    //Thong tin ca nhan -> StudentDetail //OneToOne
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="person_id")
    private Person person_student;
    //Lop hoc -> OneToOne

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="class_id")
    private Classs classs;

    //Thong tin phu huynh -> OneToOne

    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="parent_id")
    private Parent parent;
    @OneToOne(mappedBy = "student",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Scoreboard scoreboard;

    @OneToOne(mappedBy = "student",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Scoreboard scorecard;

    @OneToOne(mappedBy="student",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private SchoolRecord schoolRecord;


   @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
   @JoinTable(name="student_subject",
           joinColumns = @JoinColumn(name="student_id"),
           inverseJoinColumns = @JoinColumn(name="subject_id"))
   private List<Subject> subjects;


    public Student() {
    }

    public Student(int id, Person person_student, Classs classs, Parent parent, Scoreboard scoreboard, Scoreboard scorecard) {
        this.id = id;
        this.person_student = person_student;
        this.classs = classs;
        this.parent = parent;
        this.scoreboard = scoreboard;
        this.scorecard = scorecard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", person_student=" + person_student +
                ", classs=" + classs +
                ", parent=" + parent +
                ", scoreboard=" + scoreboard +
                ", scorecard=" + scorecard +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson_student() {
        return person_student;
    }

    public void setPerson_student(Person person_student) {
        this.person_student = person_student;
    }

    public Classs getClasss() {
        return classs;
    }

    public void setClasss(Classs classs) {
        this.classs = classs;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    public Scoreboard getScorecard() {
        return scorecard;
    }

    public void setScorecard(Scoreboard scorecard) {
        this.scorecard = scorecard;
    }
}
