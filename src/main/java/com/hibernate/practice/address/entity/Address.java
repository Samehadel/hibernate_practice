package com.hibernate.practice.address.entity;

import com.hibernate.practice.address.dto.AddressDTO;
import com.hibernate.practice.models.Auditable;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ADDRESS")
@Data
public class Address extends Auditable {

    @Id
    @GeneratedValue(generator = "addressSequenceGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "addressSequenceGenerator", sequenceName = "addressSequence", allocationSize = 1)
    @Column(name = "ADDRESS_ID")
    private Long addressId;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    public Address() {
    }
    public Address(AddressDTO address) {
        this.street = address.getStreet();
        this.city = address.getCity();
    }
}
