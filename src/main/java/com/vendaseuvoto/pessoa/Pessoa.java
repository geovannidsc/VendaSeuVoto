package com.vendaseuvoto.pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vendaseuvoto.usuarios.Usuarios;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Pessoa implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String cpf;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @OneToOne(mappedBy = "pessoa")
    private Usuarios usuario;

    public Pessoa() {
    }

    public Pessoa(String nomeCompleto, String cpf, LocalDate dataNascimento, Usuarios usuario) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nomeCompleto, pessoa.nomeCompleto) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(dataNascimento, pessoa.dataNascimento) && Objects.equals(usuario, pessoa.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeCompleto, cpf, dataNascimento, usuario);
    }
}
