package pl.sda.patientsservice.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "polish_insurance_data")
@Entity
@DiscriminatorValue("POLISH")
public class PolishInsuranceData extends InsuranceData {

    @Column(name = "insurance_institution")
    private String insuranceInstitution;
}
