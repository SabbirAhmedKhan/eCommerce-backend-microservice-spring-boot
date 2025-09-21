package com.sabbir.product.service;

import com.sabbir.product.model.dto.ProductPurchaseRequestDto;
import com.sabbir.product.model.dto.ProductPurchaseResponseDto;
import com.sabbir.product.model.dto.ProductViewRequestDto;
import com.sabbir.product.model.dto.ProductViewResponseDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Long createProduct(ProductViewRequestDto productViewRequestDto);

    List<ProductViewResponseDto> findAll();

    List<ProductPurchaseResponseDto> purchaseProducts(List<ProductPurchaseRequestDto>  productRequestDto);

    ProductViewResponseDto getProduct(Long productId);
}
