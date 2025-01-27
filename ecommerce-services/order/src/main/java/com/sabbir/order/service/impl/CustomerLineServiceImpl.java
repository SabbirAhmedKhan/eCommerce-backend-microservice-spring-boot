package com.sabbir.order.service.impl;

import com.sabbir.order.mapper.OrderLineMapper;
import com.sabbir.order.model.dto.OrderLineRequestDto;
import com.sabbir.order.model.dto.OrderLineResponseDto;
import com.sabbir.order.repository.CustomerLineRepository;
import com.sabbir.order.service.CustomerLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerLineServiceImpl implements CustomerLineService {
    private final CustomerLineRepository customerLineRepository;
    @Override
    public Integer saveCustomerLine(OrderLineRequestDto orderLineRequestDto) {
        return customerLineRepository.save(OrderLineMapper.mapToOrderLine(orderLineRequestDto)).getId(); //.mapToOrderLine(orderLineRequestDto).getId();
    }

    @Override
    public List<OrderLineResponseDto> findAllByOrderId(Integer orderId) {
        return customerLineRepository.findAllByOrderId(orderId)
                .stream()
                .map(OrderLineMapper::mapToOrderLineResponseDto)
                .toList();
    }
}
