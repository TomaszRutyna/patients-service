package pl.sda.patientsservice.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foreign_insurance_data")
@Entity
@DiscriminatorValue("FOREIGN")
public class ForeignInsuranceData extends InsuranceData{

    @Column(name = "ekuz_card_number")
    private String ekuzCard;

    @Column(name = "country_of_origin")
    private String countryOfOrigin;

}
