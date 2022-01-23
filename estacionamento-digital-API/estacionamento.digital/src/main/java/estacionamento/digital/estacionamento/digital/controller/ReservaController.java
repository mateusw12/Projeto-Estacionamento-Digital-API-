package estacionamento.digital.estacionamento.digital.controller;

import estacionamento.digital.estacionamento.digital.model.ReservaModel;
import estacionamento.digital.estacionamento.digital.repository.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @Autowired
    private IReservaRepository iReservaRepository;

    // busca por id
    @GetMapping(path = "/{codigo}")
    public ResponseEntity getById(@PathVariable("codigo") Integer codigo){
        return iReservaRepository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // metodo busca todos
    @GetMapping
    public ResponseEntity<List<ReservaModel>> getAll(){
        List<ReservaModel> lista = (List<ReservaModel>) iReservaRepository.findAll();
        return new ResponseEntity<List<ReservaModel>>(lista, HttpStatus.OK);
    }

    // metodo salvar
    @PostMapping
    public ReservaModel salvar(@RequestBody ReservaModel reserva){
        return iReservaRepository.save(reserva);
    }

    // metodo delete
    @DeleteMapping("/{codigo}")
    public ResponseEntity<ReservaModel> delete(@PathVariable("codigo") ReservaModel reserva){
        if(reserva == null){
            return ResponseEntity.notFound().build();
        }
        iReservaRepository.delete(reserva);
        return ResponseEntity.ok().build();
    }

    // metodo atualizar
    @PutMapping("/{codigo}")
    public ResponseEntity<ReservaModel> update(@PathVariable("codigo") ReservaModel reservaAntigo,
                                                    @RequestBody ReservaModel reservaAtualizado){
        // atualiza a reserva
        reservaAntigo.setcodUsuario(reservaAtualizado.getcodUsuario());
        reservaAntigo.setcodEmpresa(reservaAtualizado.getcodEmpresa());
        reservaAntigo.setcodVeiculo(reservaAtualizado.getcodVeiculo());
        reservaAntigo.setdataInicio(reservaAtualizado.getdataInicio());
        reservaAntigo.setdataFim(reservaAtualizado.getdataFim());
        reservaAntigo.setnumeroVaga(reservaAtualizado.getnumeroVaga());

        iReservaRepository.save(reservaAntigo);
        return new ResponseEntity<ReservaModel>(reservaAntigo, HttpStatus.OK);
    }


}

