package com.sabbir.customer.model.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "customer")
public record CustomerContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) { }
