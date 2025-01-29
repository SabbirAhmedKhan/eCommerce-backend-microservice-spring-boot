package com.sabbir.order.restClient;

import com.sabbir.order.exception.ResourceNotFoundException;
import com.sabbir.order.model.dto.PurchaseRequestDto;
import com.sabbir.order.model.dto.PurchaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class ProductClient {
    @Value("${application.config.product-url}")
    private String productUrl;
    private final RestTemplate restTemplate;

    public List<PurchaseResponseDto> purchaseProducts(List<PurchaseRequestDto> request) {
        //return restTemplate.postForEntity(productUrl + "/purchaseProduct", productIds, List.class).getBody();
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);

        HttpEntity<List<PurchaseRequestDto>> requestEntity = new HttpEntity<>(request, headers);
        ParameterizedTypeReference<List<PurchaseResponseDto>> responseType = new ParameterizedTypeReference<List<PurchaseResponseDto>>() {};

        ResponseEntity<List<PurchaseResponseDto>> responseEntity = restTemplate.exchange(
                productUrl + "/purchaseProduct",
                org.springframework.http.HttpMethod.POST,
                requestEntity,
                responseType
        );

        if (responseEntity.getStatusCode().isError()) {
            throw new ResourceNotFoundException("Product", "productId", responseEntity.getStatusCode().toString());
        }

        return responseEntity.getBody();
    }

}
