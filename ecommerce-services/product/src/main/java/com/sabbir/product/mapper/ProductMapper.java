package com.sabbir.product.mapper;

import com.sabbir.product.model.dto.ProductPurchaseResponseDto;
import com.sabbir.product.model.dto.ProductViewRequestDto;
import com.sabbir.product.model.dto.ProductViewResponseDto;
import com.sabbir.product.model.entity.Category;
import com.sabbir.product.model.entity.Product;

public class ProductMapper {

    public static Product mapToProduct(ProductViewRequestDto productViewResponseDto) {
        return Product.builder()
//                .productId(productViewResponseDto.id())
                .name(productViewResponseDto.name())
                .description(productViewResponseDto.description())
                .quantityAvailable(productViewResponseDto.availableQuantity())
                .price(productViewResponseDto.price())
                .category(
                        Category.builder()
                                .categoryId(productViewResponseDto.categoryId())
                                .build()
                )
                .build();
    }
    public static ProductViewResponseDto mapToProductViewResponseDto(Product product) {

        return new ProductViewResponseDto(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getQuantityAvailable(),
                product.getPrice(),
                product.getCategory().getCategoryId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public static ProductPurchaseResponseDto mapToProductPurchaseResponseDto(Product product, double quantity) {
        return new ProductPurchaseResponseDto(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }

}
