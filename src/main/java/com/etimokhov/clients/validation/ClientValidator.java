package com.etimokhov.clients.validation;

import com.etimokhov.clients.model.Client;
import com.etimokhov.clients.service.ClientService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ClientValidator implements Validator {
    private final ClientService clientService;

    public ClientValidator(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Client client = (Client) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");

        if (!client.getFirstName().matches("[ЁёА-я]+")) {
            errors.rejectValue("firstName", "illegalchars.client.firstName");
        }
        if (!client.getLastName().matches("[ЁёА-я]+")) {
            errors.rejectValue("lastName", "illegalchars.client.lastName");
        }

        if (clientService.isPassportDuplicated(client)) {
            errors.rejectValue("passportNumber", "duplicated.client.passport");
        }

        if (clientService.isPassportIdDuplicated(client)) {
            errors.rejectValue("passportID", "duplicated.client.passportID");
        }

    }
}
