package vn.pmq.spring.studentmanagement.DAO;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import vn.pmq.spring.studentmanagement.Model.Status;
import vn.pmq.spring.studentmanagement.Repository.StatusRepository;

@Repository
public class StatusDAO {
    private EntityManager entityManager;

    public StatusDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
