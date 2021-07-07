package br.com.italo.desafio.comic.lista;

import br.com.italo.desafio.comic.Comic;


public class ListaComicsPorUsuarioResponse {


    private Long id;
    private Integer comicId;
    private String titulo;
    private String isbn;
    private String descricao;
    private Double preco;

    public ListaComicsPorUsuarioResponse(Comic comic) {
        this.id = comic.getId();
        this.comicId = comic.getComicId();
        this.titulo = comic.getTitulo();
        this.isbn = comic.getIsbn();
        this.descricao = comic.getDescricao();
        this.preco = comic.getPreco();
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


}
