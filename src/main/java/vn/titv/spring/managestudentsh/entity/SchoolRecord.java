package vn.titv.spring.managestudentsh.entity;

import jakarta.persistence.*;

@Entity
@Table(name="school_record")
public class SchoolRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="score")
    private double score;
    @Column(name="conduct")
    private String conduct;//hanh kiểm
    @Column(name="comment_of_teacher")
    private String commentOfTeacher;
    @Column(name="comment_of_parents")
    private String commentOfParents;
    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="student_id")
    private Student student;

    public SchoolRecord() {
    }

    public SchoolRecord(double score, String conduct, String commentOfTeacher, String commentOfParents, Student student) {
        this.score = score;
        this.conduct = conduct;
        this.commentOfTeacher = commentOfTeacher;
        this.commentOfParents = commentOfParents;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public String getCommentOfTeacher() {
        return commentOfTeacher;
    }

    public void setCommentOfTeacher(String commentOfTeacher) {
        this.commentOfTeacher = commentOfTeacher;
    }

    public String getCommentOfParents() {
        return commentOfParents;
    }

    public void setCommentOfParents(String commentOfParents) {
        this.commentOfParents = commentOfParents;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "SchoolRecord{" +
                "id=" + id +
                ", score=" + score +
                ", conduct='" + conduct + '\'' +
                ", commentOfTeacher='" + commentOfTeacher + '\'' +
                ", commentOfParents='" + commentOfParents + '\'' +
                ", student=" + student +
                '}';
    }
}
