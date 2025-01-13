package vn.pmq.spring.studentmanagement.Service;

import vn.pmq.spring.studentmanagement.Model.Staff;

import java.util.List;

public interface StaffService {
    public List<Staff> findAll();
    public Staff findById(int id);
    public Staff addStaff(Staff staff);
    public Staff findByAccountId(int accountId);
    public Staff updateStaff(Staff staff);
}
