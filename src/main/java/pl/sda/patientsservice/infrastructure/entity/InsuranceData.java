package pl.sda.patientsservice.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "insurance_data")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "insurance_type")
public abstract class InsuranceData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "insurance_number")
    private String insuranceNumber;

}
