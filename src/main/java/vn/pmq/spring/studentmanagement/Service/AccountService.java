package vn.pmq.spring.studentmanagement.Service;

import vn.pmq.spring.studentmanagement.Model.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    public Account findById(int id);
    public Account addAccount(Account account);
    public Account updateAccount(Account account);
    public Account changeStatus(int id);
    public List<Account> findByUsernameContaining(String username);
}
