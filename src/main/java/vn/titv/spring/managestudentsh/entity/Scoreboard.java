package vn.titv.spring.managestudentsh.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="scoreboard")
public class Scoreboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    //Hoc sinh ==> Student OneToOne
    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="student_id")
    private Student student;
    @Column(name="semester")
    private int semester;//kyf hoc
    //Subject OneToMay
    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Subject> subjects;
    @Column(name="score")
    private double score;

    public Scoreboard() {
    }

    public Scoreboard(Student student, int semester, double score) {
        this.student = student;
        this.semester = semester;
        this.score = score;
    }

    public Scoreboard(int id, Student student, int semester, List<Subject> subjects, double score) {
        this.id = id;
        this.student = student;
        this.semester = semester;
        this.subjects = subjects;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Scoreboard{" +
                "id=" + id +
                ", student=" + student +
                ", semester=" + semester +
                ", subjects=" + subjects +
                ", score=" + score +
                '}';
    }
}
