package vn.pmq.spring.studentmanagement.Model;

public class Course {
    private int courseId;
    private String courseCode;
    private String courseName;
    private int termNo;
    private int numberOfSlots;

    public Course() {
    }

    public Course(int courseId, String courseCode, String courseName, int termNo, int numberOfSlots) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.termNo = termNo;
        this.numberOfSlots = numberOfSlots;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTermNo() {
        return termNo;
    }

    public void setTermNo(int termNo) {
        this.termNo = termNo;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }
}
