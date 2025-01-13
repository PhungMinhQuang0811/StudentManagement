package vn.pmq.spring.studentmanagement.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.Model.Staff;
import vn.pmq.spring.studentmanagement.Repository.StaffRepository;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    StaffRepository staffRepository;
    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public Staff findById(int id) {
        return staffRepository.getById(id);
    }

    @Override
    @Transactional
    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff findByAccountId(int accountId) {
        return staffRepository.findByAccountId(accountId);
    }

    @Override
    @Transactional
    public Staff updateStaff(Staff staff) {
        return staffRepository.saveAndFlush(staff);
    }
}
