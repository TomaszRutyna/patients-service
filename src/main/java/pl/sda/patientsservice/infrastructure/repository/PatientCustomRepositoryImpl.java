package pl.sda.patientsservice.infrastructure.repository;

import org.springframework.stereotype.Repository;
import pl.sda.patientsservice.infrastructure.dto.PatientCriteriaSearch;
import pl.sda.patientsservice.infrastructure.entity.Patient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientCustomRepositoryImpl implements PatientCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Patient> findByCriteria(PatientCriteriaSearch criteriaSearch) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Patient> query = criteriaBuilder.createQuery(Patient.class);
        Root<Patient> root = query.from(Patient.class);

        List<Predicate> predicates = new ArrayList<>();
        if (criteriaSearch.getFirstName() != null) {
            predicates.add(criteriaBuilder.equal(
                    root.get("firstName"), criteriaSearch.getFirstName()));
        }

        if (criteriaSearch.getSurName() != null) {
            predicates.add(criteriaBuilder.equal(
                    root.get("lastName"), criteriaSearch.getSurName()));
        }

        query.where(predicates.toArray(new Predicate[predicates.size()]));

        TypedQuery<Patient> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
