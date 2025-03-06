package com.sabbir.order.restClient;

import com.sabbir.order.model.dto.PurchaseRequestDto;
import com.sabbir.order.model.dto.PurchaseResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@FeignClient("product")
public interface ProductClient {
    @PostMapping("/api/v1/product/purchaseProduct")
    Optional<List<PurchaseResponseDto>> purchaseProducts(List<PurchaseRequestDto> request); // <List<PurchaseResponseDto>>
}
