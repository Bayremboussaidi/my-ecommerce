package com.example.customer_service.controller;

import com.example.customer_service.dto.CustomerRequest;
import com.example.customer_service.dto.CustomerResponse;
import com.example.customer_service.dto.ResponseMessage;
import com.example.customer_service.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.createCustomer(customerRequest);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        CustomerResponse updatedCustomer = customerService.updateCustomer(customerRequest);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAllCustomers() {
        List<CustomerResponse> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/exists/{customerId}")
    public ResponseEntity<Boolean> existsCustomerById(@PathVariable String customerId) {
        boolean exists = customerService.existsCustomerById(customerId);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> findCustomerById(@PathVariable String customerId) {
        CustomerResponse customer = customerService.findCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<ResponseMessage> deleteCustomer(@PathVariable String customerId) {
        ResponseMessage message = customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }
}
