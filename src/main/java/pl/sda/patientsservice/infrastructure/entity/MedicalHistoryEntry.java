package pl.sda.patientsservice.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medical_history_entries")
public class MedicalHistoryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    private String recognition;

    @ManyToOne
    @JoinColumn(name = "history_id")
    private MedicalHistory history;

    @ManyToMany
    @JoinTable(name = "treatments_in_entries",
            joinColumns = {@JoinColumn(name = "entry_id")},
            inverseJoinColumns = {@JoinColumn(name = "treatment_id")})
    private Set<Treatment> treatments;

}
