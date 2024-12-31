package vn.pmq.spring.studentmanagement.Model;

public class CourseType {
    private int courseTypeId;
    private String typeName;

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
