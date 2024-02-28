package vn.titv.spring.managestudentsh.entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.sql.Date;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="fullname")
    private String fullName;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="gender")
    private Boolean gender;
    @Column(name="day_of_birth")
    private Date dayOfBirth;
    @Column(name="email")
    private String email;
    @Lob
    @Column(name="avatar")
    private Blob avatar;

    @OneToOne(mappedBy ="person_employee",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Employee employee;

    @OneToOne(mappedBy = "person_student",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Student student;

    @OneToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="account_id")
    private Account account;

    public Person() {
    }

    public Person( String fullName, String phoneNumber, Boolean gender, Date dayOfBirth, String email, Blob avatar) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.email = email;
        this.avatar = avatar;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", dayOfBirth=" + dayOfBirth +
                ", email='" + email + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
