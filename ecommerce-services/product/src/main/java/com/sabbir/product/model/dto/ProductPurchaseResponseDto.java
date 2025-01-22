package com.sabbir.product.model.dto;

import java.math.BigDecimal;

public record ProductPurchaseResponseDto (
        Long productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {}