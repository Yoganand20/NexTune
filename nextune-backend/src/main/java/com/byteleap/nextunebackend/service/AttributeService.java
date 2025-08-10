package com.byteleap.nextunebackend.service;

import com.byteleap.nextunebackend.dto.request.AttributeRequestDTO;
import com.byteleap.nextunebackend.dto.response.AttributeResponseDTO;
import com.byteleap.nextunebackend.dto.response.AttributeTypeSummaryResponseDTO;

import java.util.List;

public interface AttributeService {
    AttributeResponseDTO createAttribute(AttributeRequestDTO request);

    AttributeResponseDTO updateAttribute(Long typeId, AttributeRequestDTO request);

    AttributeResponseDTO getAttribute(Long typeId);

    List<AttributeTypeSummaryResponseDTO> getAllAttributeTypes();

    void deleteAttribute(Long typeId);

    void deleteAttributeValues(Long typeId, AttributeRequestDTO request);

}
