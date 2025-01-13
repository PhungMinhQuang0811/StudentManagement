package vn.pmq.spring.studentmanagement.Service;

import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.Model.Course;
import vn.pmq.spring.studentmanagement.Model.Prerequisite;

import java.util.List;

public interface PrerequisiteService {
    public List<Prerequisite> findAll();

    public Prerequisite findById(int id);

    public Prerequisite updateCourse(Prerequisite prerequisite);
}

