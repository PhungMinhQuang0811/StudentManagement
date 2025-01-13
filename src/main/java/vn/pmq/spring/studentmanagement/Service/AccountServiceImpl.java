package vn.pmq.spring.studentmanagement.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.Model.Profile;
import vn.pmq.spring.studentmanagement.Model.Role;
import vn.pmq.spring.studentmanagement.Model.Status;
import vn.pmq.spring.studentmanagement.Repository.AccountRepository;
import vn.pmq.spring.studentmanagement.Model.Account;
import vn.pmq.spring.studentmanagement.Repository.ProfileRepository;
import vn.pmq.spring.studentmanagement.Repository.RoleRepository;
import vn.pmq.spring.studentmanagement.Repository.StatusRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private ProfileRepository profileRepository;
    private StatusRepository statusRepository;
    private RoleRepository roleRepository;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,ProfileRepository profileRepository,StatusRepository statusRepository,RoleRepository roleRepository) {
        this.accountRepository = accountRepository;
        this.profileRepository = profileRepository;
        this.statusRepository = statusRepository;
        this.roleRepository = roleRepository;
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
        int currentStatusId = account.getStatus().getstatusId();
        if (currentStatusId == 1) {
            Status newStatus = statusRepository.getById(2);
            account.setStatus(newStatus);
        } else if (currentStatusId == 2) {
            Status newStatus = statusRepository.getById(1);
            account.setStatus(newStatus);
        }
        accountRepository.saveAndFlush(account);
        return account;
    }

    @Override
    public List<Account> findByUsername(String username) {
        return accountRepository.findByUserNameIgnoreCase(username);
    }

    @Transactional
    public void addRoles(int id, List<Integer> listRoleId) {
        Account account = accountRepository.getById(id);
        List<Role> roleList = roleRepository.findAllById(listRoleId);
        account.getRoles().addAll(roleList);
        accountRepository.saveAndFlush(account);
    }
    public int getMaxId() {
        return accountRepository.findMaxId();
    }

    @Override
    public Account findByIdCard(String idCard) {
        return accountRepository.findByIdCard(idCard);
    }

    @Override
    public List<Account> findByRole(int roleId) {
        return accountRepository.findByRole(roleId);
    }



}
