package estacionamento.digital.estacionamento.digital.model;


import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity (name= "usuario")

public class UsuarioModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer codigo;

    @Column (nullable = false, length = 50)
    public String nome;

    @Column(nullable = false, length = 100)
    public String email;

    @Column(nullable = false, length = 50)
    public String senha;

    @Column(nullable = false, length = 11)
    public String cpf;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
