package vn.pmq.spring.studentmanagement.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_grade")
public class CourseGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "grade")
    private double grade;
    @Column(name = "credit",nullable = false)
    private int credits;
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

    public CourseGrade() {
    }

    public CourseGrade(int courseId, double grade, int credits) {
        this.courseId = courseId;
        this.grade = grade;
        this.credits = credits;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
