package estacionamento.digital.estacionamento.digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public  class  UserRegistrationController {

    private UserRegistrationController userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationController userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    public UserRegistrationController() {

    }
}