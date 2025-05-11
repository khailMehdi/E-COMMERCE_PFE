package org.khail.customerservice.DTO;

import org.khail.customerservice.Entity.Adresse;

public class AdresseDTO {

    private String id;
    private String street;
    private String city;
    private String postalCode;
    private String country;

    // Constructeur par défaut
    public AdresseDTO() {}

    // Constructeur qui prend une entité Adresse
    public AdresseDTO(Adresse adresse) {
        this.id = adresse.getId();
        this.street = adresse.getStreet();  // Mappage du champ street
        this.city = adresse.getCity();      // Mappage du champ city
        this.postalCode = adresse.getPostalCode(); // Mappage du champ postalCode
        this.country = adresse.getCountry();      // Mappage du champ country
    }

    // Getters et Setters
    public String getId() { return id; }
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }
    public String getCountry() { return country; }

    public void setId(String id) { this.id = id; }
    public void setStreet(String street) { this.street = street; }
    public void setCity(String city) { this.city = city; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public void setCountry(String country) { this.country = country; }
}
