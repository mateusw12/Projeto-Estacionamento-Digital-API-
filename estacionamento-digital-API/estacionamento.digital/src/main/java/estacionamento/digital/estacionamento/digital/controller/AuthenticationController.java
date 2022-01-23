package estacionamento.digital.estacionamento.digital.controller;

import estacionamento.digital.estacionamento.digital.dto.DadosLogin;
import estacionamento.digital.estacionamento.digital.dto.UserAutheticatedDTO;
import estacionamento.digital.estacionamento.digital.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import service.UserAuthenticationService;

@RestController Controller
public  class  AuthenticationController {

    private UserAuthenticationService userAuthenticationService;

    @Autowired
    public  AuthenticationController ( UserAuthenticationService  userAuthenticationService ) {
        this . userAuthenticationService = userAuthenticationService;
    }

    public  AuthenticationController () {

    }


    @PostMapping("/login")
    public ResponseEntity<UserAutheticatedDTO> autenticar(@RequestBody DadosLogin dadosLogin, @RequestHeader String Authorization){
        User user = userAuthenticationService.authenticate(dadosLogin, Authorization);
        return new ResponseEntity<>(<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    }
}
}