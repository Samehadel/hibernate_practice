package com.hibernate.practice.address.entity;

import com.hibernate.practice.author.entity.Author;
import com.hibernate.practice.models.Auditable;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

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
}
