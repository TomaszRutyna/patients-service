package pl.sda.patientsservice.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.patientsservice.infrastructure.entity.Patient;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByLastNameLike(String lastName);
    List<Patient> findByLastNameAndFirstName(String lastName, String firstName);

    Optional<Patient> findFirstByHistory_Number(String number);
    List<Patient> findByIdIsIn(List<Long> ids);
    List<Patient> findByIdBetween(Long from, Long to);

    List<Patient> findDistinctByFirstName(String firstName);

    void deleteByLastName(String lastName);

    @Query("select pat from Patient pat " +
            "inner join fetch pat.history " +
            "where (pat.firstName = :firstName or :firstName is null) and " +
            "(pat.lastName = :lastName or :lastName is null)")
    List<Patient> findByLastNameAndFirstNameSeparately(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName);






}
