package pl.sda.patientsservice.infrastructure.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.patientsservice.infrastructure.dto.PatientDto;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String pesel;

    public static Patient fromDto(PatientDto dto) {
        return Patient.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .pesel(dto.getPesel())
                .build();
    }

    public PatientDto toDto() {
        return PatientDto.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .pesel(pesel)
                .build();
    }
}
