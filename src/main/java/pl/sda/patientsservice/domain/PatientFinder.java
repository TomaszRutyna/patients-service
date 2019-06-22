package pl.sda.patientsservice.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.patientsservice.infrastructure.dto.PatientDto;
import pl.sda.patientsservice.infrastructure.entity.Patient;
import pl.sda.patientsservice.infrastructure.repository.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientFinder {

    private final PatientRepository patientRepository;

    public List<PatientDto> findAll() {
        return patientRepository.findAll().stream().map(Patient::toDto).collect(Collectors.toList());
    }

    public Optional<PatientDto> findOne(Long id) {
        return patientRepository.findById(id).map(Patient::toDto);
    }
}
