package com.byteleap.nextunebackend.repository;

import com.byteleap.nextunebackend.entity.attribute.AttributeType;
import com.byteleap.nextunebackend.entity.attribute.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {

    boolean existsByAttributeTypeAndValue(AttributeType attributeType, String value);

    @Transactional
    @Modifying
    @Query("DELETE FROM AttributeValue av WHERE av.attributeType.typeId = :typeId AND av.value IN :values")
    void deleteByAttributeTypeIdAndValueIn(@Param("typeId") Long typeId, @Param("values") Set<String> values);
}
