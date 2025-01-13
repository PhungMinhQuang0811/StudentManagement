package vn.pmq.spring.studentmanagement.Service;

import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.Model.Account;
import vn.pmq.spring.studentmanagement.Model.Course;

import java.util.List;
public interface CourseService {
    public List<Course> findAll();

    public Course addCourse(Course Course);

    public Course findById(int id);

    public Course updateCourse(Course course);
}
