package vn.pmq.spring.studentmanagement.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.Model.Course;
import vn.pmq.spring.studentmanagement.Model.Prerequisite;
import vn.pmq.spring.studentmanagement.Repository.prerequisiteRepository;

import java.util.List;

@Service
public class PrerequisiteServiceIml implements PrerequisiteService {
    @Autowired
    prerequisiteRepository repo;

    @Override
    public List<Prerequisite> findAll() {
        return repo.findAll();
    }

    @Override
    public Prerequisite findById(int id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Prerequisite updateCourse(Prerequisite prerequisite) {
        return repo.saveAndFlush(prerequisite);
    }
}
