package estacionamento.digital.estacionamento.digital.repository;

import estacionamento.digital.estacionamento.digital.model.EmpresaModel;
import org.springframework.data.repository.CrudRepository;

public interface IEmpresaRepository extends CrudRepository<EmpresaModel, Integer> {
}
