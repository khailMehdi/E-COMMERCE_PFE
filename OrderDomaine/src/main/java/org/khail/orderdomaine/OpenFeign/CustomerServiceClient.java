package org.khail.orderdomaine.OpenFeign;

import org.khail.orderdomaine.CustomerOrder.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="customer-service")
public interface CustomerServiceClient {
    @GetMapping("/customer/{id}")
    List<Customer> getCustomersByIds(String id);

}
