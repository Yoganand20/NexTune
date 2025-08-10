package com.byteleap.nextunebackend.controllers;

import com.byteleap.nextunebackend.dto.request.AttributeRequestDTO;
import com.byteleap.nextunebackend.dto.response.AttributeResponseDTO;
import com.byteleap.nextunebackend.dto.response.AttributeTypeSummaryResponseDTO;
import com.byteleap.nextunebackend.service.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/attributes")
public class AttributeController {


    private final AttributeService attributeService;

    @GetMapping
    public ResponseEntity<List<AttributeTypeSummaryResponseDTO>> getAllAttributes() {
        List<AttributeTypeSummaryResponseDTO> summaryList = attributeService.getAllAttributeTypes();
        return ResponseEntity.ok(summaryList);
    }

    @GetMapping(value = "/{typeId}")
    public ResponseEntity<AttributeResponseDTO> getAttribute(@PathVariable Long typeId) {
        AttributeResponseDTO dto = attributeService.getAttribute(typeId);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AttributeResponseDTO> createAttributeType(
            @RequestBody @Validated(AttributeRequestDTO.CreateWithName.class) AttributeRequestDTO request) {
        AttributeResponseDTO responseDTO = attributeService.createAttribute(request);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{typeId}")
    public ResponseEntity<AttributeResponseDTO> updateAttribute(
            @PathVariable Long typeId,
            @RequestBody @Validated(AttributeRequestDTO.CreateWithoutName.class) AttributeRequestDTO request) {

        AttributeResponseDTO responseDTO = attributeService.updateAttribute(typeId, request);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{typeId}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable Long typeId) {
        attributeService.deleteAttribute(typeId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{typeId}/values")
    public ResponseEntity<Void> deleteAttributeValues(
            @PathVariable Long typeId,
            @RequestBody @Validated(AttributeRequestDTO.CreateWithoutName.class) AttributeRequestDTO request) {

        attributeService.deleteAttributeValues(typeId, request);
        return ResponseEntity.noContent().build();
    }
}