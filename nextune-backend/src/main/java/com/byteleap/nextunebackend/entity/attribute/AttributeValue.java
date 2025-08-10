package com.byteleap.nextunebackend.entity.attribute;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "attribute_values")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "attributeType")
@ToString(exclude = "attributeType")
public class AttributeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "value_id", columnDefinition = "BIGINT UNSIGNED")
    private Long valueId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", columnDefinition = "BIGINT UNSIGNED")
    @JsonBackReference
    @NotNull(message = "Attribute type is required")
    private AttributeType attributeType;

    @Column(name = "value", nullable = false, length = 100)
    @NotBlank(message = "Attribute value is required")
    @Size(max = 100, message = "Attribute value must not exceed 100 characters")
    private String value;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

}
