package org.khail.customerservice.Web;

import org.khail.customerservice.DTO.CustomerDTO;

import org.khail.customerservice.Exception.CustomerNotFoundException;
import org.khail.customerservice.Exception.EmailAlreadyUsedException;
import org.khail.customerservice.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerWeb {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable String id)
            throws CustomerNotFoundException {
        return customerService.getCustomerById(id);
    }

    @PostMapping()
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }

    @PutMapping()
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO)
            throws CustomerNotFoundException, EmailAlreadyUsedException {
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id)
            throws CustomerNotFoundException {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/customer/{kw}")
   public List<CustomerDTO> getCustomerByName(@PathVariable String kw)
            throws CustomerNotFoundException {
        return customerService.getCustomersByName(kw);
    }

}