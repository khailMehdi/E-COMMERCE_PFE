package org.khail.customerservice.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.ModuleMainClass;
import org.khail.customerservice.DTO.AdresseDTO;
import org.khail.customerservice.DTO.CustomerDTO;
import org.khail.customerservice.Entity.Adresse;
import org.khail.customerservice.Entity.Customer;
import org.khail.customerservice.Exception.CustomerNotFoundException;
import org.khail.customerservice.Exception.EmailAlreadyUsedException;
import org.khail.customerservice.Repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(String id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
        return new CustomerDTO(customer);
    }


    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        System.out.println(customerDTO);
        // Liste pour stocker les adresses
        List<Adresse> adresses = new ArrayList<>();

        // Mapper les adresses du DTO vers les entités Adresse
        if (customerDTO.getAdresses() != null && !customerDTO.getAdresses().isEmpty()) {
            for (AdresseDTO adresseDTO : customerDTO.getAdresses()) {
                Adresse adresse = new Adresse();
                adresse.setId(UUID.randomUUID().toString());
                adresse.setStreet(adresseDTO.getStreet());
                adresse.setCity(adresseDTO.getCity());
                adresse.setPostalCode(adresseDTO.getPostalCode());
                adresse.setCountry(adresseDTO.getCountry());
                adresse.setCustomer(customer); // Associer cette adresse au client
                adresses.add(adresse);
            }
            System.out.println(customerDTO.getAdresses());
            customer.setAdresse(adresses);  // Associer les adresses au client
        }

        // Enregistrer le client et ses adresses dans la base de données
        customer = customerRepository.save(customer);  // Cela va persister le client et ses adresses associées

        // Retourner le CustomerDTO avec le client et ses adresses
        return new CustomerDTO(customer);  // Convertir Customer en CustomerDTO et retourner


    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO)
            throws CustomerNotFoundException, EmailAlreadyUsedException {
        // Vérifie si le client existe
        Customer existingCustomer = customerRepository.findById(customerDTO.getId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerDTO.getId()));

        // Vérifie si l'email est utilisé par un autre client
        List<Customer> customerWithEmail = customerRepository.findByEmail(customerDTO.getEmail());
        for (Customer customer : customerWithEmail) {
            if (!customer.getId().equals(customerDTO.getId())) {
                throw new EmailAlreadyUsedException("Email is already used by another customer.");
            }
        }


        // Map les champs du DTO vers l'entité existante (mais garde l'objet existant pour préserver les relations ou champs non modifiables)
        modelMapper.map(customerDTO, existingCustomer);

        // Sauvegarde l'entité mise à jour
        Customer updatedCustomer = customerRepository.save(existingCustomer);

        // Retourne le DTO mis à jour
        return modelMapper.map(updatedCustomer, CustomerDTO.class);
    }


    @Override
    public void deleteCustomer(String id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
        customerRepository.delete(customer);
    }

    @Override
    public List<CustomerDTO> getCustomersByName(String keyword)
            throws CustomerNotFoundException {
        List<Customer> customers = customerRepository.findByFirstName(keyword);
        if (customers.isEmpty()) {
            throw new CustomerNotFoundException("Aucun client trouvé avec le mot-clé : " + keyword);
        }
        return customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

}

