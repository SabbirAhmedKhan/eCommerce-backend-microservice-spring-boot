package com.sabbir.customer.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

@Embeddable
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    private String houseNumber;
    private String roadNumber;
    private String zipCode;
}
