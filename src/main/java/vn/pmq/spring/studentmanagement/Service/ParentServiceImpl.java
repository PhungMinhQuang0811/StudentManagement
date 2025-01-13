package vn.pmq.spring.studentmanagement.Service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.Model.Parent;
import vn.pmq.spring.studentmanagement.Repository.ParentRepository;

import java.util.List;
@Service
public class ParentServiceImpl implements ParentService {
    private ParentRepository parentRepository;

    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public List<Parent> getAllParent() {
        return parentRepository.findAll();
    }

    @Override
    public Parent getParentById(int id) {
        return parentRepository.getById(id);
    }

    @Override
    @Transactional
    public Parent addParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    @Transactional
    public Parent updateParent(Parent parent) {
        return parentRepository.saveAndFlush(parent);
    }

    @Override
    public Parent findByAccountId(int accountId) {
        return parentRepository.findByAccountId(accountId);
    }
}
