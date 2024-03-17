package com.hibernate.practice.address.dto;

import com.hibernate.practice.address.entity.Address;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDTO implements Serializable {
    private String street;
    private String city;

    public AddressDTO(Address address) {
        this.street = address.getStreet();
        this.city = address.getCity();
    }
}
