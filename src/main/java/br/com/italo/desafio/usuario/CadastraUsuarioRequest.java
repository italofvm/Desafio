package br.com.italo.desafio.usuario;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class CadastraUsuarioRequest {

    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @CPF
    private String cpf;
    @NotNull @Past
    private LocalDate dataDeNascimento;

    public CadastraUsuarioRequest(String nome, String email, String cpf, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Usuario toUsuario() {
        return new Usuario(nome, email, cpf, dataDeNascimento);
    }
}
