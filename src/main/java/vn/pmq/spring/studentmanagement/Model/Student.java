package vn.pmq.spring.studentmanagement.Model;

public class Student {
    private int studentId;
    private String studentCode;
    private String major;
    private String memberCode;
    private String currentTermNo;

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

    public void setcurrentTermNo(String currentTermNo) {
        this.currentTermNo = currentTermNo;
    }
}
