package vn.pmq.spring.studentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.pmq.spring.studentmanagement.Model.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("SELECT a.accountId, r.roleId FROM Account a JOIN a.roles r WHERE a.accountId = :accountId")
    public List<Object[]> findRoleIdsByAccountId(@Param("accountId") int accountId);

    List<Account> findByUserNameIgnoreCase(String userName);

    @Query("SELECT COALESCE(MAX(a.accountId), 0) FROM Account a")
    public int findMaxId();
    @Query("SELECT a from Account a join fetch a.profile p where p.idCard = :idCard")
    public Account findByIdCard(@Param("idCard") String idCard);
    @Query("SELECT a from Account a join fetch a.roles r where r.roleId = :roleId")
    public List<Account> findByRole(@Param("roleId") int roleId);


}
