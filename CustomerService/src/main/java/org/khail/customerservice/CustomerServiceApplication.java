package org.khail.customerservice;

import org.khail.customerservice.Entity.Adresse;
import org.khail.customerservice.Entity.Customer;
import org.khail.customerservice.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
  /*  @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository) {
        return args -> {
            Customer customer = new Customer();
            customer.setId(UUID.randomUUID().toString());
            customer.setFirstName("Mehdi");
            customer.setLastName("Khail");
            customer.setEmail("mehdi@gmail.com");
            customer.setPhone("987654321");

            Adresse address1 = new Adresse();
            address1.setId(UUID.randomUUID().toString());
            address1.setStreet("10 Rue de Casa");
            address1.setCity("casa");
            address1.setPostalCode("75008");
            address1.setCountry("Maroce");
            address1.setCustomer(customer);

            Adresse address2 = new Adresse();
            address2.setId(UUID.randomUUID().toString());
            address2.setStreet("20 Avenue de Lyon");
            address2.setCity("Lyon");
            address2.setPostalCode("69002");
            address2.setCountry("France");
            address2.setCustomer(customer);

            customer.setAdresse(Arrays.asList(address1, address2));

            customerRepository.save(customer);

            System.out.println("✅ Base de données initialisée avec un client !");

        };
        } */
}
