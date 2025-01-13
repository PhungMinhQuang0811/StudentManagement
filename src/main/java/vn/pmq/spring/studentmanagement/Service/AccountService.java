package vn.pmq.spring.studentmanagement.Service;

import vn.pmq.spring.studentmanagement.Model.Account;
import vn.pmq.spring.studentmanagement.Model.Profile;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    public Account findById(int id);
    public Account addAccount(Account account);
    public Account updateAccount(Account account);
    public Account changeStatus(int id);
    public List<Account> findByUsername(String username);
    public int getMaxId();
    public Account findByIdCard(String idCard);
    public List<Account> findByRole(int roleId);
}
