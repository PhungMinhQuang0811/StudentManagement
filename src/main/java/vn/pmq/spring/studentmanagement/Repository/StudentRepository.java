package vn.pmq.spring.studentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.pmq.spring.studentmanagement.Model.Staff;
import vn.pmq.spring.studentmanagement.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s from Student s join fetch s.account a where a.accountId = :accountId")
    public Student findByAccountId(@Param("accountId") int accountId);
}
