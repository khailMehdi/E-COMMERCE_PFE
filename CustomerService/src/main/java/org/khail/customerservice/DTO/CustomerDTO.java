package org.khail.customerservice.DTO;

import org.khail.customerservice.Entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private List<AdresseDTO> adresses;

    public CustomerDTO() {
    }
    // Constructeur qui prend un Customer pour initialiser le DTO
    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();

        // Vérifier si le client a des adresses et les mapper
        if (customer.getAdresses() != null && !customer.getAdresses().isEmpty()) {
            this.adresses = customer.getAdresses().stream()
                    .map(adresse -> new AdresseDTO(adresse)) // Conversion des adresses en AdresseDTO
                    .collect(Collectors.toList());
        } else {
            this.adresses = new ArrayList<>(); // Liste vide si pas d'adresses
        }
    }

    // Getters
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public List<AdresseDTO> getAdresses() { return adresses; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAdresses(List<AdresseDTO> adresses) { this.adresses = adresses; }
}
