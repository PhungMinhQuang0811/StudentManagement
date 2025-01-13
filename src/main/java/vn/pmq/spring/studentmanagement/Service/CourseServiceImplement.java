package vn.pmq.spring.studentmanagement.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.Model.Account;
import vn.pmq.spring.studentmanagement.Model.Course;
import vn.pmq.spring.studentmanagement.Repository.CourseRepository;
import vn.pmq.spring.studentmanagement.Repository.StatusRepository;

import java.util.List;

@Service
public class CourseServiceImplement implements CourseService {
    @Autowired
    private CourseRepository courseRepo;

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course findById(int id) {
        return courseRepo.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Course updateCourse(Course course) {
        return courseRepo.saveAndFlush(course);
    }


}
