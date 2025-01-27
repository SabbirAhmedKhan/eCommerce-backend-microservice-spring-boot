package com.sabbir.order.model.dto;

public record CustomerResponseDto(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
