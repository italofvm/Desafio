package br.com.italo.desafio.usuario;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataDeNascimento;

    @Deprecated
    public Usuario() {
    }

    public Usuario(String nome, String email, String cpf, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Long getId() {
        return id;
    }
}
