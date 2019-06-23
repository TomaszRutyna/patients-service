package pl.sda.patientsservice.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.patientsservice.infrastructure.entity.converter.JoinedStringConverter;
import pl.sda.patientsservice.infrastructure.entity.type.RefundationType;

import javax.persistence.*;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "treatments")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String nfzId;

    @Enumerated(EnumType.STRING)
    @Column(name = "refundation_type")
    private RefundationType refundationType;

    @Column(name = "used_drugs")
    @Convert(converter = JoinedStringConverter.class)
    private Set<String> usedDrugs;

    @Column(length = 2000)
    private String desctription;

    @Column(name = "operator_id", nullable = false)
    private String operatorId;
}
