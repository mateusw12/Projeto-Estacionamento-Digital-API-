package estacionamento.digital.estacionamento.digital.controller;
import estacionamento.digital.estacionamento.digital.model.VeiculoModel;
import estacionamento.digital.estacionamento.digital.repository.IVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

    @Autowired
    private IVeiculoRepository iVeiculoRepository;

    // busca por id
    @GetMapping(path = "/{codigo}")
    public ResponseEntity getById(@PathVariable("codigo") Integer codigo){
        return iVeiculoRepository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // metodo busca todos
    @GetMapping
    public ResponseEntity<List<VeiculoModel>> getAll(){
        List<VeiculoModel> lista = (List<VeiculoModel>) iVeiculoRepository.findAll();
        return new ResponseEntity<List<VeiculoModel>>(lista, HttpStatus.OK);
    }

    // metodo salvar
    @PostMapping
    public VeiculoModel salvar(@RequestBody VeiculoModel veiculo){
        return iVeiculoRepository.save(veiculo);
    }

    // metodo delete
    @DeleteMapping("/{codigo}")
    public ResponseEntity<VeiculoModel> delete(@PathVariable("codigo") VeiculoModel veiculo){
        if(veiculo == null){
            return ResponseEntity.notFound().build();
        }
        iVeiculoRepository.delete(veiculo);
        return ResponseEntity.ok().build();
    }

    // metodo atualizar
    @PutMapping("/{codigo}")
    public ResponseEntity<VeiculoModel> update(@PathVariable("codigo") VeiculoModel veiculoAntigo,
                                               @RequestBody VeiculoModel veiculoAtualizado){
        // atualiza o veiculo
        veiculoAntigo.setVeiculo(veiculoAtualizado.getVeiculo());
        veiculoAntigo.setRenavam(veiculoAtualizado.getRenavam());
        veiculoAntigo.setAno(veiculoAtualizado.getAno());
        veiculoAntigo.setCor(veiculoAtualizado.getCor());
        veiculoAntigo.setPlaca(veiculoAtualizado.getPlaca());

        iVeiculoRepository.save(veiculoAntigo);
        return new ResponseEntity<VeiculoModel>(veiculoAntigo, HttpStatus.OK);
    }


}
