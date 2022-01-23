package estacionamento.digital.estacionamento.digital.repository;

import estacionamento.digital.estacionamento.digital.model.ReservaModel;
import estacionamento.digital.estacionamento.digital.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface IReservaRepository extends CrudRepository<ReservaModel, Integer> {
}
