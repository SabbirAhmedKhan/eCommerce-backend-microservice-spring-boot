package com.sabbir.order.model.dto;

import java.math.BigDecimal;

public record PurchaseResponseDto(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {}
