package vn.pmq.spring.studentmanagement.DAO;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.pmq.spring.studentmanagement.Model.Account;
import vn.pmq.spring.studentmanagement.Model.Status;
import vn.pmq.spring.studentmanagement.Repository.AccountRepository;
import vn.pmq.spring.studentmanagement.Repository.StatusRepository;

@Repository
public class AccountDAO {
    private EntityManager entityManager;
    private AccountRepository accountRepository;
    private StatusRepository statusRepository;
    @Autowired
    public AccountDAO(EntityManager entityManager,AccountRepository accountRepository, StatusRepository statusRepository) {
        this.entityManager = entityManager;
        this.accountRepository = accountRepository;
        this.statusRepository = statusRepository;
    }
    public Account changeStatus(Account account) {
        if(account.getStatus().getstatusId() == 1){
            Status newStatus = statusRepository.getById(2);
            account.setStatus(newStatus);
        } else if (account.getStatus().getstatusId() == 2) {
            Status newStatus = statusRepository.getById(1);
            account.setStatus(newStatus);
        }
        accountRepository.saveAndFlush(account);
        return account;
    }
    public int getMaxId() {
        String sql = "select max(a.id) from Account a";
        Integer maxId = entityManager.createQuery(sql, Integer.class).getSingleResult();
        return maxId != null ? maxId : 0; // Return 0 if no records exist
    }
}
