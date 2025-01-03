package vn.pmq.spring.studentmanagement.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.DAO.AccountDAO;
import vn.pmq.spring.studentmanagement.Model.Role;
import vn.pmq.spring.studentmanagement.Model.Status;
import vn.pmq.spring.studentmanagement.Repository.AccountRepository;
import vn.pmq.spring.studentmanagement.Model.Account;
import vn.pmq.spring.studentmanagement.Repository.RoleRepository;
import vn.pmq.spring.studentmanagement.Repository.StatusRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private StatusRepository statusRepository;
    private RoleRepository roleRepository;
    private AccountDAO accountDAO;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,StatusRepository statusRepository,RoleRepository roleRepository, AccountDAO accountDAO) {
        this.accountRepository = accountRepository;
        this.statusRepository = statusRepository;
        this.roleRepository = roleRepository;
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(int id) {
        return accountRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Account addAccount(Account account) {
        Status defaultStatus = statusRepository.getById(1);

        account.setStatus(defaultStatus);
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public Account updateAccount(Account account) {
        return accountRepository.saveAndFlush(account);
    }

    @Override
    @Transactional
    public Account changeStatus(int id) {
        Account account = accountRepository.getById(id);
        return accountDAO.changeStatus(account);
    }

    @Override
    public List<Account> findByUsernameContaining(String username) {
        return accountRepository.findByUserNameContainingIgnoreCase(username);
    }

    @Transactional
    public void addRoles(int id, List<Integer> listRoleId) {
        Account account = accountRepository.getById(id);
        List<Role> roleList = roleRepository.findAllById(listRoleId);
        account.getRoles().addAll(roleList);
        accountRepository.saveAndFlush(account);
    }
}
