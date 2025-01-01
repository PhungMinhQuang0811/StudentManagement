package vn.pmq.spring.studentmanagement.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "prerequisite")
public class Prerequisite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prerequisite_id")
    private int prerequisiteId;
    @Column(name = "name",length = 50,nullable = false)
    private String name;
    @Column(name = "course_code",length = 10,nullable = false)
    private String courseCode;
    @OneToOne(mappedBy = "prerequisite",fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    private Course course;
    public Prerequisite(int prerequisiteId, String name) {
        this.prerequisiteId = prerequisiteId;
        this.name = name;
    }

    public Prerequisite(String name, String courseCode) {
        this.name = name;
        this.courseCode = courseCode;
    }

    public Prerequisite() {
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getprerequisiteId() {
        return prerequisiteId;
    }

    public void setprerequisiteId(int prerequisiteId) {
        this.prerequisiteId = prerequisiteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
