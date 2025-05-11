package org.khail.customerservice.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Adresse {
    @Id
    private String id;
    private String street;
    private String city;
    private String postalCode;
    private String country;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {this.postalCode = postalCode;}
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
