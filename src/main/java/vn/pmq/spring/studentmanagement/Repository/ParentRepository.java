package vn.pmq.spring.studentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.pmq.spring.studentmanagement.Model.Parent;
import vn.pmq.spring.studentmanagement.Model.Staff;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {
    @Query("SELECT p from Parent p join fetch p.account a where a.accountId = :accountId")
    public Parent findByAccountId(@Param("accountId") int accountId);
}
