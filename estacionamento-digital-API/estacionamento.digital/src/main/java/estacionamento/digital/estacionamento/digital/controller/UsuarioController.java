package estacionamento.digital.estacionamento.digital.controller;

import estacionamento.digital.estacionamento.digital.model.UsuarioModel;
import estacionamento.digital.estacionamento.digital.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    // busca por id
    @GetMapping(path = "/{codigo}")
    public ResponseEntity getById(@PathVariable("codigo") Integer codigo){
        return iUsuarioRepository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // metodo busca todos
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAll(){
        List<UsuarioModel> lista = (List<UsuarioModel>) iUsuarioRepository.findAll();
        return new ResponseEntity<List<UsuarioModel>>(lista,HttpStatus.OK);
    }

    // metodo salvar
    @PostMapping
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario){
        return iUsuarioRepository.save(usuario);
    }

    // metodo delete
    @DeleteMapping("/{codigo}")
    public ResponseEntity<UsuarioModel> delete(@PathVariable("codigo") UsuarioModel usuario){
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        iUsuarioRepository.delete(usuario);
        return ResponseEntity.ok().build();
    }

    // metodo atualizar
    @PutMapping("/{codigo}")
    public ResponseEntity<UsuarioModel> update(@PathVariable("codigo") UsuarioModel usuarioAntigo,
                                           @RequestBody UsuarioModel usuarioAtualizado){
       // atualiza o usuario
        usuarioAntigo.setNome(usuarioAtualizado.getNome());
        usuarioAntigo.setEmail(usuarioAtualizado.getEmail());
        usuarioAntigo.setCpf(usuarioAtualizado.getCpf());
        usuarioAntigo.setSenha(usuarioAtualizado.getSenha());

        iUsuarioRepository.save(usuarioAntigo);
        return new ResponseEntity<UsuarioModel>(usuarioAntigo, HttpStatus.OK);
    }


}
