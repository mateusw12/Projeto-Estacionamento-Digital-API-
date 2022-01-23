package estacionamento.digital.estacionamento.digital.model;

import javax.persistence.*;

import java.sql.Date;

@Entity(name= "reserva")
public class ReservaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer codigo;

    @Column(nullable = false)
    public Integer codusuario;

    @Column(nullable = false)
    public Integer codempresa;

    @Column(nullable = false)
    public Integer codveiculo;

    @Column(nullable = false)
    public Date datainicio;

    @Column(nullable = false)
    public Date datafim;

    @Column(nullable = false,length = 9999999 )
    public String numerovaga;


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getcodUsuario() {
        return codusuario;
    }

    public void setcodUsuario(Integer codusuario) {
        this.codusuario = codusuario;
    }

    public Integer getcodEmpresa() {
        return codempresa;
    }

    public void setcodEmpresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Integer getcodVeiculo() {
        return codveiculo;
    }

    public void setcodVeiculo(Integer codveiculo) {
        this.codveiculo= codveiculo;
    }

    public Date getdataInicio() {
        return datainicio;
    }

    public void setdataInicio(Date datainicio) {
        this.datainicio = datainicio;
    }
    public Date getdataFim() {
        return datafim;
    }

    public void setdataFim(Date datafim) {
        this.datafim = datafim;
    }
    public String getnumeroVaga() {
        return numerovaga;
    }

    public void setnumeroVaga(String numerovaga) {
        this.numerovaga = numerovaga;
    }
}

