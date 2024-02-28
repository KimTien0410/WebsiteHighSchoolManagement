package vn.titv.spring.managestudentsh.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="username",length = 60)
    private String username;
    @Column(name="password",length = 255)
    private String password;
    @Column(name="active")
    private Boolean active;
    @OneToOne(mappedBy ="account",cascade = CascadeType.ALL)
    private Person person;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="account_role",
                joinColumns=@JoinColumn(name="account_id"),
                inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH,
//                    CascadeType.MERGE,
//                    CascadeType.PERSIST,
//                    CascadeType.REFRESH})
//    @JoinTable(name="course_student",
//            joinColumns = @JoinColumn(name="student_id"),
//            inverseJoinColumns = @JoinColumn(name="course_id")
//    )
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account() {
    }

    public Account(String username, String password, Boolean active) {
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
