package com.example.customer_service.dto;

import com.example.customer_service.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CustomerRequest {

    private String id;

    @NotBlank(message = "Customer firstname is required")
    private String firstName;

    @NotBlank(message = "Customer lastname is required")
    private String lastName;

    @NotBlank(message = "Customer Email is required")
    @Email(message = "Customer Email is not a valid email address")
    private String email;

    private Address address;
}
