package vn.pmq.spring.studentmanagement.Model;

public class Mark {
    private int courseId;
    private double pt1;
    private double pt2;
    private double lab1;
    private double lab2;
    private double assignment;
    private double PE;
    private double FE;

    public Mark(int courseId, double pt1, double pt2, double lab1, double lab2, double assignment, double PE, double FE) {
        this.courseId = courseId;
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.lab1 = lab1;
        this.lab2 = lab2;
        this.assignment = assignment;
        this.PE = PE;
        this.FE = FE;
    }

    public Mark() {
    }

    public int getcourseId() {
        return courseId;
    }

    public void setcourseId(int courseId) {
        this.courseId = courseId;
    }

    public double getPt1() {
        return pt1;
    }

    public void setPt1(double pt1) {
        this.pt1 = pt1;
    }

    public double getPt2() {
        return pt2;
    }

    public void setPt2(double pt2) {
        this.pt2 = pt2;
    }

    public double getLab1() {
        return lab1;
    }

    public void setLab1(double lab1) {
        this.lab1 = lab1;
    }

    public double getLab2() {
        return lab2;
    }

    public void setLab2(double lab2) {
        this.lab2 = lab2;
    }

    public double getAssignment() {
        return assignment;
    }

    public void setAssignment(double assignment) {
        this.assignment = assignment;
    }

    public double getPE() {
        return PE;
    }

    public void setPE(double PE) {
        this.PE = PE;
    }

    public double getFE() {
        return FE;
    }

    public void setFE(double FE) {
        this.FE = FE;
    }
}
