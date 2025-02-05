package com.sabbir.order.model.dto;

public record CustomerResponseDto(
        String firstName,
        String lastName,
        String email,
        String mobileNumber
) {
}
