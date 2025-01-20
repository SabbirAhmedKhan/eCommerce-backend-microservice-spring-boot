package com.sabbir.customer.service.impl;

import com.sabbir.customer.exception.CustomerAlreadyExistsException;
import com.sabbir.customer.exception.ResourceNotFoundException;
import com.sabbir.customer.mapper.AddressMapper;
import com.sabbir.customer.mapper.CustomerMapper;
import com.sabbir.customer.model.dto.CustomerDto;
import com.sabbir.customer.model.entity.Customer;
import com.sabbir.customer.repository.CustomerRepository;
import com.sabbir.customer.service.CustomerService;
import io.micrometer.common.util.StringUtils;
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
//        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(mobileNumber);
//        if(!customerOptional.isPresent()) {
//            throw new ResourceNotFoundException("Customer", "mobile Number", mobileNumber);
//        }
//        return CustomerMapper.mapToCustomerDto(customerOptional.get());
        return this.customerRepository.findByMobileNumber(mobileNumber)
                .map(CustomerMapper::mapToCustomerDto)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobile Number", mobileNumber));
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

    private void mergeCustomer(Customer customer, CustomerDto customerDto) {
        if(StringUtils.isNotBlank(customerDto.firstName())) {
            customer.setFirstName(customerDto.firstName());
        }
        if(StringUtils.isNotBlank(customerDto.lastName())) {
            customer.setLastName(customerDto.lastName());
        }
        if(StringUtils.isNotBlank(customerDto.email())) {
            customer.setEmail(customerDto.email());
        }
        if(StringUtils.isNotBlank(customerDto.mobileNumber())) {
            customer.setMobileNumber(customerDto.mobileNumber());
        }
        if(customerDto.address() != null) {
            customer.setAddress(AddressMapper.mapToAddress(customerDto.address()));
        }
    }

    @Override
    public Boolean updateCustomer(CustomerDto customerDto) {
        Boolean isUpdated = false;
        Customer customer = customerRepository.findByMobileNumber(customerDto.mobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobile Number", customerDto.mobileNumber())
        );
        mergeCustomer(customer, customerDto);
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
