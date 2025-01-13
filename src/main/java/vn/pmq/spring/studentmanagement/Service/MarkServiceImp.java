package vn.pmq.spring.studentmanagement.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.Model.Course;
import vn.pmq.spring.studentmanagement.Model.Mark;
import vn.pmq.spring.studentmanagement.Model.Status;
import vn.pmq.spring.studentmanagement.Repository.MarkRepository;
import vn.pmq.spring.studentmanagement.Repository.StatusRepository;

import java.util.List;

@Service
public class MarkServiceImp implements MarkService {
    private MarkRepository markRepository;
    private StatusRepository statusRepository;

    @Autowired
    public MarkServiceImp(MarkRepository markRepository, StatusRepository statusRepository) {
        this.markRepository = markRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void addMark(int courseId) {
        Status status = statusRepository.findById(1).orElseThrow();
        if (status != null) {
            Mark mark = new Mark(courseId, 0, 0, 0, 0, 0, 0, 0, status);
            markRepository.save(mark);
        }
    }

    @Override
    public Mark findById(int id) {
        return markRepository.findByCourseId(id).orElseThrow();
    }

    @Override
    @Transactional
    public Mark updateMark(Mark mark) {
        return markRepository.saveAndFlush(mark);
    }
}
