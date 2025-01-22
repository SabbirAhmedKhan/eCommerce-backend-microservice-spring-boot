package com.sabbir.product.model.dto;

import java.math.BigDecimal;

public record ProductViewResponseDto (
    Long id,
    String name,
    String description,
    double availableQuantity,
    BigDecimal price,
    Long categoryId,
    String categoryName,
    String categoryDescription
) {}
