package estacionamento.digital.estacionamento.digital.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class statusController {

    @GetMapping(path = "/api/status")
    public String check(){
        return "online";
    }
}
