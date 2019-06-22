package pl.sda.patientsservice.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.patientsservice.infrastructure.dto.PatientDto;
import pl.sda.patientsservice.infrastructure.entity.Patient;
import pl.sda.patientsservice.infrastructure.repository.PatientRepository;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Long create(PatientDto dto) {
        return patientRepository.save(Patient.fromDto(dto)).getId();
    }

    public Long edit(PatientDto dto) {
        if (dto.getId() == null) {
            return -1L;
        }
        return patientRepository.save(Patient.fromDto(dto)).getId();
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
