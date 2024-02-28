package vn.titv.spring.managestudentsh.entity;

import jakarta.persistence.*;

@Entity
@Table(name="parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="gender")
    private Boolean gender;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="address")
    private String address;
    //OneToOne Student
    @OneToOne(mappedBy = "parent",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Student student;

    public Parent() {
    }

    public Parent(String fullName, Boolean gender, String phoneNumber, String address) {
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Parent(int id, String fullName, Boolean gender, String phoneNumber, String address, Student student) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.student = student;
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", student=" + student +
                '}';
    }
}
