package vn.pmq.spring.studentmanagement.Service;

import vn.pmq.spring.studentmanagement.Model.Parent;

import java.util.List;

public interface ParentService {
    public List<Parent> getAllParent();
    public Parent getParentById(int id);
    public Parent addParent(Parent parent);
    public Parent updateParent(Parent parent);
    public Parent findByAccountId(int accountId);
}
