package estacionamento.digital.estacionamento.digital.model;
import javax.persistence.*;

@Entity (name= "veiculo")

public class VeiculoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer codigo;

    @Column (nullable = false, length = 50)
    public String veiculo;

    @Column(nullable = false, length = 11)
    public Integer renavam;

    @Column(nullable = false, length = 4)
    public String ano;

    @Column(nullable = false, length = 50)
    public String cor;

    @Column(nullable = false, length = 7)
    public String placa;


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Integer getRenavam() { return renavam;}

    public void setRenavam(Integer renavam) {
        this.renavam = renavam;
    }

    public  String getAno() {
        return ano;
    }

    public void setAno(String ano) {this.ano = ano; }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
