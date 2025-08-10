package com.byteleap.nextunebackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributeResponseDTO {
    private Long typeId;
    private String name;
    private Set<String> values;
}
