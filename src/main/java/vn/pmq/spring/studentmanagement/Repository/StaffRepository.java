package vn.pmq.spring.studentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.pmq.spring.studentmanagement.Model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
