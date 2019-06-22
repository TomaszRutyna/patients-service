package pl.sda.patientsservice.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.patientsservice.infrastructure.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
