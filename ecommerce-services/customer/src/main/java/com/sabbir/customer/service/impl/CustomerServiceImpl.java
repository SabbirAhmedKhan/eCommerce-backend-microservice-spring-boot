package com.sabbir.customer.service.impl;

import com.sabbir.customer.exception.CustomerAlreadyExistsException;
import com.sabbir.customer.exception.ResourceNotFoundException;
import com.sabbir.customer.mapper.CustomerMapper;
import com.sabbir.customer.model.dto.CustomerDto;
import com.sabbir.customer.model.entity.Customer;
import com.sabbir.customer.repository.CustomerRepository;
import com.sabbir.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    @Override
    public Long createCustomer(CustomerDto customerDto) {
//        System.out.println("customerDto = " + customerDto);
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(customerDto.mobileNumber());
        if (customerOptional.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber " + customerDto.mobileNumber());
        }
        System.out.println("Customer = " + customer);
        customerRepository.save(customer);
        return customer.getCustomerId();
    }

    @Override
    public CustomerDto fetchCustomer(String mobileNumber) {
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(mobileNumber);
        if(!customerOptional.isPresent()) {
            throw new ResourceNotFoundException("Customer", "mobile Number", mobileNumber);
        }
        return CustomerMapper.mapToCustomerDto(customerOptional.get());
    }

    @Override
    public CustomerDto fetchCustomer(Long customerId) {
//        Optional<Customer> customerOptional = customerRepository.findById(customerId);
//        if(!customerOptional.isPresent()) {
//            return null;
//        }
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobile Number", customerId.toString())
        );
        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public Boolean updateCustomer(CustomerDto customerDto) {
        Boolean isUpdated = false;
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(customerDto.mobileNumber());
        if(!customerOptional.isPresent()) {
            new ResourceNotFoundException("Customer", "mobile Number", customerDto.mobileNumber());
        }
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        customer.setCustomerId(customerOptional.get().getCustomerId());
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Boolean deleteCustomer(String mobileNumber) {
        Boolean isUpdated = false;
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Customer", "Mobile no", mobileNumber)
        );
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(mobileNumber);
        if(!customerOptional.isPresent()) {
            return false;
        }
        customerRepository.delete(customerOptional.get());
        return true;
    }

}
