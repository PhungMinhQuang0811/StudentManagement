package vn.pmq.spring.studentmanagement.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private int attendanceId;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @JoinTable(
            name = "course_attendance",
            joinColumns = @JoinColumn(name = "attendance_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    @JoinColumn(name = "status_id",nullable = false)
    private Status status;

    public Attendance() {
    }

    public Attendance(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }
}
