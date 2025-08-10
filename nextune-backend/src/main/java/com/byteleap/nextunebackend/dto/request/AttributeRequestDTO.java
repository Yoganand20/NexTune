package com.byteleap.nextunebackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributeRequestDTO {
    @NotBlank(groups = CreateWithName.class)
    @Size(max = 50)
    private String name;

    @Size(max = 100)
    private Set<@NotBlank @Size(max = 100) String> values = new HashSet<>();

    public interface CreateWithName {
    }

    public interface CreateWithoutName {
    }
}