package estacionamento.digital.estacionamento.digital.repository;

import estacionamento.digital.estacionamento.digital.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository <User, Long> {
    Optional<User> findByEmail(String email);
}