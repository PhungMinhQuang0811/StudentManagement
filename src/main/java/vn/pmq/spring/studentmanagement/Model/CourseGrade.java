package vn.pmq.spring.studentmanagement.Model;

public class CourseGrade {
    private int course_id;
    private double grade;
    private int credits;

    public CourseGrade() {
    }

    public CourseGrade(int course_id, double grade, int credits) {
        this.course_id = course_id;
        this.grade = grade;
        this.credits = credits;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
