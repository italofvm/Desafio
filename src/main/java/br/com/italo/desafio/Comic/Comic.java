package br.com.italo.desafio.comic;

import br.com.italo.desafio.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.stream.Stream;

@Entity
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Integer comicId;
    @NotBlank
    private String titulo;
    @NotBlank
    private String isbn;
    @Column(columnDefinition = "TEXT")
    @NotBlank
    private String descricao;
    @NotNull
    private Double preco;

    @ManyToOne
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private DiaDeDesconto diaDeDesconto;

    @Deprecated
    public Comic() {
    }

    public Comic(Integer comicId, String titulo, String isbn, String descricao, Double preco, Usuario usuario) {
        this.comicId = comicId;
        this.titulo = titulo;
        this.isbn = isbn;
        this.descricao = descricao;
        this.preco = preco;
        this.usuario = usuario;
        this.diaDeDesconto = adicionaDiaDeDesconto();
    }

    public Long getId() {
        return id;
    }


    public Integer getComicId() {
        return comicId;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public DiaDeDesconto getDiaDeDesconto() {
        return diaDeDesconto;
    }

    private DiaDeDesconto adicionaDiaDeDesconto() {
        var digito = Integer.valueOf(isbn.substring(isbn.length() - 1));
        return Stream.of(DiaDeDesconto.values())
                .filter(d -> d.verificaDia(digito))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }
}
