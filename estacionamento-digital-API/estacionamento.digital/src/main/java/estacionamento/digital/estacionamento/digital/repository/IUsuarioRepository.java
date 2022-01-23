package estacionamento.digital.estacionamento.digital.repository;

import estacionamento.digital.estacionamento.digital.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
}
