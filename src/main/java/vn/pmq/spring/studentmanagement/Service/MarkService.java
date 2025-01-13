package vn.pmq.spring.studentmanagement.Service;

import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.Model.Course;
import vn.pmq.spring.studentmanagement.Model.Mark;

import java.util.List;

public interface MarkService {

    public void addMark(int CourseId);
    public Mark findById(int id);

    public Mark updateMark(Mark mark);
}
