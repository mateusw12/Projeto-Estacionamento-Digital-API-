package service;

import estacionamento.digital.estacionamento.digital.model.User;
import estacionamento.digital.estacionamento.digital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TokenService;

@Service
public class UserRegistrationService {

    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    public UserRegistrationService(UserRepository userRepository, TokenService tokenService){
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User registrate(User user){
        user.setToken(tokenService.generateToken(user));
        return userRepository.save(user);
    }

}
