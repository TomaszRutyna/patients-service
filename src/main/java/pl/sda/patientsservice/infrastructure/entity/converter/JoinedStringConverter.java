package pl.sda.patientsservice.infrastructure.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Converter
public class JoinedStringConverter implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(Set<String> strings) {
        return String.join(";", strings);
    }

    @Override
    public Set<String> convertToEntityAttribute(String s) {
        return new HashSet(Arrays.asList(s.split(";")));
    }
}
