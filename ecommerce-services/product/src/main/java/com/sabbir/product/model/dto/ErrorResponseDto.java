package com.sabbir.product.model.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

//@Data @AllArgsConstructor
public record ErrorResponseDto(String apiPath, HttpStatus errorCode, String errorMessage, LocalDateTime errorTime) {}
