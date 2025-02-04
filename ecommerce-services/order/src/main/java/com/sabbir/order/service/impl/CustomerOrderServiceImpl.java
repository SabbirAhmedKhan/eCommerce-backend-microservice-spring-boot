package com.sabbir.order.service.impl;

import com.sabbir.order.exception.ResourceNotFoundException;
import com.sabbir.order.mapper.OrderMapper;
import com.sabbir.order.model.dto.OrderRequestDto;
import com.sabbir.order.model.dto.OrderResponseDto;
import com.sabbir.order.repository.CustomerOrderRepository;
import com.sabbir.order.service.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerOrderServiceImpl implements CustomerOrderService {
    private final CustomerOrderRepository customerOrderRepository;

    @Override
    @Transactional
    public Integer createOrder(OrderRequestDto orderRequestDto) {
        return customerOrderRepository.save(OrderMapper.mapToOrder(orderRequestDto)).getId();
    }

    @Override
    public List<OrderResponseDto> findAllCustomerOrder() {
        return customerOrderRepository.findAll().stream().map(OrderMapper::mapToOrderResponseDto).toList();
//        return List.of();
    }

    @Override
    public OrderResponseDto findCustomerOrderById(Integer id) {
        return customerOrderRepository.findById(id).map(OrderMapper::mapToOrderResponseDto).orElseThrow(
                ()-> new ResourceNotFoundException("Order", "id", id.toString()));
    }
}
