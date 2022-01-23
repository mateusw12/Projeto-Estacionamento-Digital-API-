package estacionamento.digital.estacionamento.digital.model;

import javax.persistence.*;

@Entity(name= "empresa")
public class EmpresaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer codigo;

    @Column(nullable = false, length = 200)
    public String nome;

    @Column(nullable = false, length = 200)
    public String senha;

    @Column(nullable = false, length = 11)
    public String cnpj;

    @Column(nullable = false, length = 200)
    public String nomeFantasia;
    @Column(nullable = false, length = 9)
    public String cep;

    @Column(nullable = false, length = 200)
    public String cidade;

    @Column(nullable = false, length = 11)
    public String bairro;

    @Column(nullable = false, length = 200)
    public String endereço;

    @Column(nullable = false, length = 9)
    public String estado;


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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
