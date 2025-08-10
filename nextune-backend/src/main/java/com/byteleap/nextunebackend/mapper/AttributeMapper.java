package com.byteleap.nextunebackend.mapper;


import com.byteleap.nextunebackend.dto.request.AttributeRequestDTO;
import com.byteleap.nextunebackend.dto.response.AttributeResponseDTO;
import com.byteleap.nextunebackend.dto.response.AttributeTypeSummaryResponseDTO;
import com.byteleap.nextunebackend.entity.attribute.AttributeType;
import com.byteleap.nextunebackend.entity.attribute.AttributeValue;
import org.mapstruct.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AttributeMapper {

    @Mapping(target = "typeId", source = "typeId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "values", source = "attributeValues", qualifiedByName = "mapAttributesToValues")
    AttributeResponseDTO toResponseDTO(AttributeType attributeType);

    @Mapping(target = "typeId", ignore = true)
    @Mapping(target = "attributeValues", source = "values", qualifiedByName = "mapValuesToAttributes")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AttributeType toEntity(AttributeRequestDTO reqDTO);

    @Mapping(target = "typeId", source = "typeId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "createdAt", expression = "java(entity.getCreatedAt() != null ? entity.getCreatedAt().toString() : null)")
    @Mapping(target = "updatedAt", expression = "java(entity.getUpdatedAt() != null ? entity.getUpdatedAt().toString() : null)")
    AttributeTypeSummaryResponseDTO toSummaryDTO(AttributeType entity);

    // Helper method to map Set<Attribute> to Set<String>
    @Named("mapAttributesToValues")
    default Set<String> mapAttributesToValues(Set<AttributeValue> attributes) {
        if (attributes == null) {
            return new HashSet<>();
        }
        return attributes.stream()
                .map(AttributeValue::getValue)
                .collect(Collectors.toSet());
    }

    // Helper method to map Set<String> to Set<Attribute>
    @Named("mapValuesToAttributes")
    default Set<AttributeValue> mapValuesToAttributes(Set<String> values) {
        if (values == null) {
            return new HashSet<>();
        }
        return values.stream()
                .map(value -> {
                    AttributeValue attribute = new AttributeValue();
                    attribute.setValue(value);
                    return attribute;
                })
                .collect(Collectors.toSet());
    }

    @AfterMapping
    default void linkAttributeValues(
            AttributeRequestDTO dto,
            @MappingTarget AttributeType attributeType) {
        if (attributeType.getAttributeValues() != null) {
            attributeType.getAttributeValues()
                    .forEach(av -> av.setAttributeType(attributeType));
        }
    }
}
