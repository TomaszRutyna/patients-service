package pl.sda.patientsservice.infrastructure.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.patientsservice.domain.PatientFinder;
import pl.sda.patientsservice.domain.PatientService;
import pl.sda.patientsservice.infrastructure.dto.PatientDto;

import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientFinder patientFinder;
    private final PatientService patientService;


    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getOne(@PathVariable Long id) {
        return patientFinder.findOne(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAll() {
        return ResponseEntity.ok(patientFinder.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PatientDto patientDto) {
        patientService.create(patientDto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PatientDto patientDto) {
        patientService.edit(patientDto);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.status(204).build();

    }
}
