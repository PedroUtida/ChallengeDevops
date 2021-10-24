package br.com.fiap.challenge.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="usuario",sequenceName = "SQ_T_USUARIO",allocationSize = 1)
public class Usuario {

    @Id
    @GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
    private int codigo;

    private String nome;

    private LocalDate dataNascimento;

   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
