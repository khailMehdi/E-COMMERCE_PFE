package org.khail.customerservice.Service;

import org.khail.customerservice.DTO.CustomerDTO;
import org.khail.customerservice.Entity.Customer;
import org.khail.customerservice.Exception.CustomerNotFoundException;
import org.khail.customerservice.Exception.EmailAlreadyUsedException;

import java.util.List;

public interface CustomerService {
    public List<CustomerDTO> getAllCustomers();
    public CustomerDTO getCustomerById(String id)throws CustomerNotFoundException;
    public CustomerDTO addCustomer(CustomerDTO customer);
    public CustomerDTO updateCustomer(CustomerDTO customer) throws CustomerNotFoundException, EmailAlreadyUsedException;
    public void deleteCustomer(String id) throws CustomerNotFoundException;
    List<CustomerDTO> getCustomersByName(String keyWord) throws CustomerNotFoundException;

}
