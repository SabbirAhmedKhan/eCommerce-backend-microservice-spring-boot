package com.sabbir.product.controller;

import com.sabbir.product.model.dto.ProductPurchaseRequestDto;
import com.sabbir.product.model.dto.ProductPurchaseResponseDto;
import com.sabbir.product.model.dto.ProductViewRequestDto;
import com.sabbir.product.model.dto.ProductViewResponseDto;
import com.sabbir.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<Long> createProduct(@RequestBody @Valid ProductViewRequestDto productRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productRequest));
    }

    @PostMapping("/purchaseProduct")
    public ResponseEntity<List<ProductPurchaseResponseDto>> purchaseProducts(@RequestBody @Valid List<ProductPurchaseRequestDto>  productRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.purchaseProducts(productRequest));
    }

    @GetMapping("/getProduct")
    public ResponseEntity<ProductViewResponseDto> getProduct(@RequestParam Long productId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProduct(productId));
    }

    @GetMapping("findAll")
    public ResponseEntity<List<ProductViewResponseDto>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

}
