package vn.pmq.spring.studentmanagement.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courseType")
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_type_id")
    private int courseTypeId;
    @Column(name = "type_name",length = 10,nullable = false)
    private String typeName;
    @OneToMany(mappedBy = "courseType",fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH
    })
    private List<Mark> marks;

    public CourseType(int courseTypeId, String typeName) {
        this.courseTypeId = courseTypeId;
        this.typeName = typeName;
    }

    public CourseType() {
    }

    public int getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(int courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
