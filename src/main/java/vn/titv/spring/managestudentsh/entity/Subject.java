package vn.titv.spring.managestudentsh.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="title")
    private String title;
    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Employee> employees;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="scorecard_id")
    private Scorecard scorecard;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="scoreboard_id")
    private Scorecard scoreboard;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name="student_subject",
                joinColumns = @JoinColumn(name="subject_id"),
                inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> students;

    public Subject() {
    }

    public Subject(int id, String title, List<Employee> employees, Scorecard scorecard, Scorecard scoreboard) {
        this.id = id;
        this.title = title;
        this.employees = employees;
        this.scorecard = scorecard;
        this.scoreboard = scoreboard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Scorecard getScorecard() {
        return scorecard;
    }

    public void setScorecard(Scorecard scorecard) {
        this.scorecard = scorecard;
    }

    public Scorecard getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(Scorecard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", employees=" + employees +
                ", scorecard=" + scorecard +
                ", scoreboard=" + scoreboard +
                '}';
    }
}
