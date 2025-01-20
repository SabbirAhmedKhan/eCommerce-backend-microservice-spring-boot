package com.sabbir.customer.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddressDto(@NotNull(message = "houseNumber name is required")
                         @Size(min = 3, max = 30, message = "houseNumber must be between 3 and 30 characters")
                         String houseNumber,
                         @NotNull(message = "roadNumber is required")
                         @Size(min = 3, max = 30, message = "roadNumber must be between 3 and 30 characters")
                         String roadNumber,
                         @NotNull(message = "zipCode is required")
                         String zipCode) {}

