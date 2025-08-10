package com.byteleap.nextunebackend.entity.attribute;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "attribute_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "attributeValues")
@ToString(exclude = "attributeValues")
public class AttributeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id", columnDefinition = "BIGINT UNSIGNED")
    private Long typeId;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank(message = "Attribute type name is required")
    @Size(max = 50, message = "Attribute type name must not exceed 50 characters")
    private String name;

    @OneToMany(mappedBy = "attributeType", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<AttributeValue> attributeValues = new HashSet<>();

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    public void addAttributeValue(AttributeValue value) {
        attributeValues.add(value);
        value.setAttributeType(this);
    }

    public void removeAttributeValue(AttributeValue value) {
        attributeValues.remove(value);
        value.setAttributeType(null);
    }

}
