package org.khail.customerservice.Exception;

public class EmailAlreadyUsedException extends Exception {
    public EmailAlreadyUsedException(String email) {
        super(email);
    }
}
