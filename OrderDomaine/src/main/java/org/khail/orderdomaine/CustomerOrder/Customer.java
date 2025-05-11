package org.khail.orderdomaine.CustomerOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter

public class Customer {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
}
