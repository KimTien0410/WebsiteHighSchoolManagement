package vn.titv.spring.managestudentsh.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="scorecard")
public class Scorecard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    //học sinh ..> OneToOne
    //Subject -> OneToMany

    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="student_id")
    private Student student;
    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Subject> subject;
    @Column(name="date_of_exam")
    private Date dateOfExam;
    @Column(name="score")
    private Double score;

    public Scorecard() {
    }

    public Scorecard(Student student, List<Subject> subject, Date dateOfExam, Double score) {
        this.student = student;
        this.subject = subject;
        this.dateOfExam = dateOfExam;
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

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    public Date getDateOfExam() {
        return dateOfExam;
    }

    public void setDateOfExam(Date dateOfExam) {
        this.dateOfExam = dateOfExam;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Scorecard{" +
                "id=" + id +
                ", student=" + student +
                ", subject=" + subject +
                ", dateOfExam=" + dateOfExam +
                ", score=" + score +
                '}';
    }
}
