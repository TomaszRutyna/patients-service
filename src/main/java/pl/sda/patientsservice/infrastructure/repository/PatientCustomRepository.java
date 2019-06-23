package pl.sda.patientsservice.infrastructure.repository;

import pl.sda.patientsservice.infrastructure.dto.PatientCriteriaSearch;
import pl.sda.patientsservice.infrastructure.entity.Patient;

import java.util.List;

public interface PatientCustomRepository {

    List<Patient> findByCriteria(PatientCriteriaSearch criteriaSearch);
}
