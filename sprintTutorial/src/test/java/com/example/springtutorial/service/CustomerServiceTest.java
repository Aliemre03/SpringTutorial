package com.example.springtutorial.service;

import com.example.springtutorial.dto.converter.CustomerDtoConverter;
import com.example.springtutorial.exception.CustomerNotFoundException;
import com.example.springtutorial.model.Customer;
import com.example.springtutorial.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

public class CustomerServiceTest {

    private CustomerService service;
    private CustomerRepository customerRepository;
    private CustomerDtoConverter converter;

    @BeforeEach
    public void setUp() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        converter = Mockito.mock(CustomerDtoConverter.class);
        service = new CustomerService(customerRepository, converter);
    }

    @Test
    public void testFindByCustomerID_whenCustomerIdExist_shouldReturnCustomer() {
        Customer customer = new Customer("id", "name", "surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));

        Customer result = service.findCustomerById("id");

        Assert.assertEquals(result, customer);
    }

    @Test
    public void testFindByCustomerID_whenCustomerIdExist_shouldThrowCustomerNotFoundExcep() {
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());
        Assert.assertThrows(CustomerNotFoundException.class, () ->service.findCustomerById("id"));
    }


}