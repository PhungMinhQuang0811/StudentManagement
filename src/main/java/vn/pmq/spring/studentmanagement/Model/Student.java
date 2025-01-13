package vn.pmq.spring.studentmanagement.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "student_code",length = 10,nullable = false)
    private String studentCode;
    @Column(name = "major",length = 25,nullable = false)
    private String major;
    @Column(name = "member_code",length = 50,nullable = false)
    private String memberCode;
    @Column(name = "current_term_no",nullable = false)
    private String currentTermNo;
    @OneToOne(mappedBy = "student",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private Account account;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;
    @OneToOne(mappedBy = "student",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Finance finance;

    public Student(int studentId, String studentCode, String major, String memberCode, String currentTermNo) {
        this.studentId = studentId;
        this.studentCode = studentCode;
        this.major = major;
        this.memberCode = memberCode;
        this.currentTermNo = currentTermNo;
    }

    public Student() {
    }

    public int getstudentId() {
        return studentId;
    }

    public void setstudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getstudentCode() {
        return studentCode;
    }

    public void setstudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getmemberCode() {
        return memberCode;
    }

    public void setmemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getcurrentTermNo() {
        return currentTermNo;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setcurrentTermNo(String currentTermNo) {
        this.currentTermNo = currentTermNo;
    }
}
