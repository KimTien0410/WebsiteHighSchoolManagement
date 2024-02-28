package vn.titv.spring.managestudentsh.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name_school")
    private String nameSchool;
    @Column(name="address")
    private String address;
    @Column(name="phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Classs> classses;

    public School(int id, String nameSchool, String address, String phoneNumber) {
        this.id = id;
        this.nameSchool = nameSchool;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public School() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Classs> getClasses() {
        return classses;
    }

    public void setClasses(List<Classs> classses) {
        this.classses = classses;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", nameSchool='" + nameSchool + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", classes=" + classses +
                '}';
    }
}
