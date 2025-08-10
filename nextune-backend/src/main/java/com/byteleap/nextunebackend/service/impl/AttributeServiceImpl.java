package com.byteleap.nextunebackend.service.impl;

import com.byteleap.nextunebackend.dto.request.AttributeRequestDTO;
import com.byteleap.nextunebackend.dto.response.AttributeResponseDTO;
import com.byteleap.nextunebackend.dto.response.AttributeTypeSummaryResponseDTO;
import com.byteleap.nextunebackend.entity.attribute.AttributeType;
import com.byteleap.nextunebackend.entity.attribute.AttributeValue;
import com.byteleap.nextunebackend.mapper.AttributeMapper;
import com.byteleap.nextunebackend.repository.AttributeTypeRepository;
import com.byteleap.nextunebackend.repository.AttributeValueRepository;
import com.byteleap.nextunebackend.service.AttributeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {

    private final AttributeTypeRepository attributeTypeRepository;

    private final AttributeValueRepository attributeValueRepository;

    private final AttributeMapper attributeMapper;

    @Transactional
    @Override
    public AttributeResponseDTO createAttribute(AttributeRequestDTO request) {
        AttributeType attributeType = attributeMapper.toEntity(request);
        return attributeMapper.toResponseDTO(attributeTypeRepository.save(attributeType));
    }

    @Transactional
    @Override
    public AttributeResponseDTO updateAttribute(Long typeId, AttributeRequestDTO request) {
        AttributeType attributeType = attributeTypeRepository.findById(typeId)
                .orElseThrow(() -> new EntityNotFoundException("AttributeType not found with id: " + typeId));

        if (request.getName() != null && !request.getName().trim().isEmpty()) {
            attributeType.setName(request.getName());
        }
        if (request.getValues() != null && !request.getValues().isEmpty()) {
            addValuesToAttributeType(attributeType, request.getValues());
        }
        return attributeMapper.toResponseDTO(attributeTypeRepository.save(attributeType));
    }

    @Override
    public AttributeResponseDTO getAttribute(Long typeId) {
        AttributeType entity = attributeTypeRepository
                .findById(typeId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "AttributeType not found with id " + typeId
                ));
        return attributeMapper.toResponseDTO(entity);
    }

    @Override
    public List<AttributeTypeSummaryResponseDTO> getAllAttributeTypes() {
        List<AttributeType> entities = attributeTypeRepository.findAll();
        return entities.stream()
                .map(attributeMapper::toSummaryDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteAttribute(Long typeId) {
        AttributeType entity = attributeTypeRepository.findById(typeId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "AttributeType not found with id " + typeId
                ));
        attributeTypeRepository.delete(entity);
    }

    @Override
    @Transactional
    public void deleteAttributeValues(Long typeId, AttributeRequestDTO request) {

        AttributeType attributeType = attributeTypeRepository.findById(typeId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "AttributeType not found with id " + typeId
                ));

        Set<String> valuesToDelete = request.getValues();

        attributeValueRepository.deleteByAttributeTypeIdAndValueIn(attributeType.getTypeId(), valuesToDelete);
    }


    private void addValuesToAttributeType(AttributeType attributeType, Set<String> values) {
        for (String value : values) {
            // Check if the value already exists to avoid duplicates
            if (!attributeValueRepository.existsByAttributeTypeAndValue(attributeType, value)) {
                AttributeValue attributeValue = new AttributeValue();
                attributeValue.setValue(value);
                attributeType.addAttributeValue(attributeValue);
            }
        }
    }
}