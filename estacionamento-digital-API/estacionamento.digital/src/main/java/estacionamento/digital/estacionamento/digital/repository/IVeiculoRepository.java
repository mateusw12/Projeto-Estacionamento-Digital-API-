package estacionamento.digital.estacionamento.digital.repository;

import estacionamento.digital.estacionamento.digital.model.VeiculoModel;
import org.springframework.data.repository.CrudRepository;

public interface IVeiculoRepository extends CrudRepository<VeiculoModel, Integer> {
}
