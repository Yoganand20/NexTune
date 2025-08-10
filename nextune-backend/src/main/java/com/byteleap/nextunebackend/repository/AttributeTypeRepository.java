package com.byteleap.nextunebackend.repository;

import com.byteleap.nextunebackend.entity.attribute.AttributeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeTypeRepository extends JpaRepository<AttributeType, Long> {

}