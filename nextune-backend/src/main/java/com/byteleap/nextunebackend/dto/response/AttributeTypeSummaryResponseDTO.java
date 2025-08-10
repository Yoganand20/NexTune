package com.byteleap.nextunebackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributeTypeSummaryResponseDTO {
    private Long typeId;
    private String name;
    private String createdAt;
    private String updatedAt;
}
