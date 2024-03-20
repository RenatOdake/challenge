package com.desafio.msCatalog.category.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryDTORequest(
        @NotNull(message = "Name can't be null")
        @NotBlank(message = "Name can't be blank")
        String name,
        @NotNull(message = "Name can't be null")
        Boolean active,
        @Nullable
        Long parentId
) {
}
