package vn.pmq.spring.studentmanagement.Model;

import jakarta.persistence.*;
import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;
    @Column(name = "username",length = 50,nullable = false)
    private String userName;
    @Column(name = "password",length = 256,nullable = false)
    private String password;
    @Column(name = "email",length = 256,nullable = false)
    private String email;
    @Column(name = "phone",length = 256,nullable = false)
    private String phone;
    @Column(name = "fullname",length = 256,nullable = false)
    private String fullName;
    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profile profile;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @JoinTable(
            name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id",nullable = true)
    private Parent parent;
    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id",nullable = true)
    private Student student;
    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "staff_id",nullable = true)
    private Staff staff;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id",nullable = false)
    private Status status;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @JoinTable(
            name = "account_class",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private List<Class> classes;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @JoinTable(
            name = "account_course",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
    public Account() {
    }

    public Account(int accountId, String userName, String fullName, String password, String email, String phone) {
        this.accountId = accountId;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Account(String userName, String password, String email, String phone, String fullName) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.fullName = fullName;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
    public String getFirstName() {
        String trimmed = this.fullName.trim();
        int a = trimmed.lastIndexOf(" ");
        String name = trimmed.substring(a+1);
        return name;
    }
    public String getFirstCharOfLastName() {
        String trimmed = this.fullName.trim();
        String[] nameParts = trimmed.split(" ");
        if (nameParts.length < 2) {
            return ""; // Return empty string if there are no last names
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nameParts.length-1; i++) {
            sb.append(nameParts[i].charAt(0));
        }
        return sb.toString();
    }
}
