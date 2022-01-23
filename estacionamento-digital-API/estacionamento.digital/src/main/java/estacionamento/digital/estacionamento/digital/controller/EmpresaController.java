package estacionamento.digital.estacionamento.digital.controller;

import estacionamento.digital.estacionamento.digital.model.EmpresaModel;
import estacionamento.digital.estacionamento.digital.repository.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private IEmpresaRepository iEmpresaRepository;

    // busca por id
    @GetMapping(path = "/{codigo}")
    public ResponseEntity getById(@PathVariable("codigo") Integer codigo){
        return iEmpresaRepository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // metodo busca todos
    @GetMapping
    public ResponseEntity<List<EmpresaModel>> getAll(){
        List<EmpresaModel> lista = (List<EmpresaModel>) iEmpresaRepository.findAll();
        return new ResponseEntity<List<EmpresaModel>>(lista, HttpStatus.OK);
    }

    // metodo salvar
    @PostMapping
    public EmpresaModel salvar(@RequestBody EmpresaModel empresa){
        return iEmpresaRepository.save(empresa);
    }

    // metodo delete
    @DeleteMapping("/{codigo}")
    public ResponseEntity<EmpresaModel> delete(@PathVariable("codigo") EmpresaModel empresa){
        if(empresa == null){
            return ResponseEntity.notFound().build();
        }
        iEmpresaRepository.delete(empresa);
        return ResponseEntity.ok().build();
    }

    // metodo atualizar
    @PutMapping("/{codigo}")
    public ResponseEntity<EmpresaModel> update(@PathVariable("codigo") EmpresaModel empresaAntigo,
                                               @RequestBody EmpresaModel empresaAtualizado){
        // atualizar a Empresa
        empresaAntigo.setNome(empresaAtualizado.getNome());
        empresaAntigo.setSenha(empresaAtualizado.getSenha());
        empresaAntigo.setCnpj(empresaAtualizado.getCnpj());
        empresaAntigo.setNomeFantasia(empresaAtualizado.getNomeFantasia());
        empresaAntigo.setCep(empresaAtualizado.getCep());
        empresaAntigo.setCidade(empresaAtualizado.getCidade());
        empresaAntigo.setBairro(empresaAtualizado.getBairro());
        empresaAntigo.setEndereço(empresaAtualizado.getEndereço());
        empresaAntigo.setEstado(empresaAtualizado.getEstado());

        iEmpresaRepository.save(empresaAntigo);
        return new ResponseEntity<EmpresaModel>(empresaAntigo, HttpStatus.OK);
    }


}
