package vn.pmq.spring.studentmanagement.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "pt1",nullable = false)
    private double pt1;
    @Column(name = "pt2",nullable = false)
    private double pt2;
    @Column(name = "lab1",nullable = false)
    private double lab1;
    @Column(name = "lab2",nullable = false)
    private double lab2;
    @Column(name = "assignment",nullable = false)
    private double assignment;
    @Column(name = "pe")
    private double PE;
    @Column(name = "fe",nullable = false)
    private double FE;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @JoinColumn(name = "status_id",nullable = false)
    private Status status;
    @OneToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @MapsId
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @JoinColumn(name = "course_type_id",nullable = false)
    private CourseType courseType;

    public Mark(int courseId, double pt1, double pt2, double lab1, double lab2, double assignment, double PE, double FE, Status status) {
        this.courseId = courseId;
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.lab1 = lab1;
        this.lab2 = lab2;
        this.assignment = assignment;
        this.PE = PE;
        this.FE = FE;
        this.status = status;
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

    @Override
    public String toString() {
        return "Mark{" +
                "courseId=" + courseId +
                ", pt1=" + pt1 +
                ", pt2=" + pt2 +
                ", lab1=" + lab1 +
                ", lab2=" + lab2 +
                ", assignment=" + assignment +
                ", PE=" + PE +
                ", FE=" + FE +
                ", status=" + status +
                ", course=" + course +
                ", courseType=" + courseType +
                '}';
    }
}
