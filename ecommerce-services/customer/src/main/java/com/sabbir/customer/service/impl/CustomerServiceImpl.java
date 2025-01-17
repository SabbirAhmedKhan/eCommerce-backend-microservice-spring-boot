package com.sabbir.customer.service.impl;

import com.sabbir.customer.mapper.CustomerMapper;
import com.sabbir.customer.model.dto.CustomerDto;
import com.sabbir.customer.model.entity.Customer;
import com.sabbir.customer.repository.CustomerRepository;
import com.sabbir.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    @Override
    public Long createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(customerDto.mobileNumber());
        if (customerOptional.isPresent()) {
            //TODO: return error
            return customerOptional.get().getCustomerId();
        }
        customerRepository.save(customer);
        return customer.getCustomerId();
    }

    @Override
    public CustomerDto fetchCustomer(String mobileNumber) {
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(mobileNumber);
        if(!customerOptional.isPresent()) {
            //TODO: return error
            return null;
        }
        return CustomerMapper.mapToCustomerDto(customerOptional.get());
    }

    @Override
    public CustomerDto fetchCustomer(Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(!customerOptional.isPresent()) {
            //TODO: return error
            return null;
        }
        return CustomerMapper.mapToCustomerDto(customerOptional.get());
    }

    @Override
    public Boolean updateCustomer(CustomerDto customerDto) {
        Boolean isUpdated = false;
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(customerDto.mobileNumber());
        if(!customerOptional.isPresent()) {
            return false;
        }
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        customer.setCustomerId(customerOptional.get().getCustomerId());
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Boolean deleteCustomer(String mobileNumber) {
        Boolean isUpdated = false;
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(mobileNumber);
        if(!customerOptional.isPresent()) {
            return false;
        }
        customerRepository.delete(customerOptional.get());
        return true;
    }

}
